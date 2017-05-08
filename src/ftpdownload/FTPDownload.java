/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpdownload;

/**
 *
 * @author Corailla20
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
 
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPDownload {
 
    private static OracleConnector oracleConnector = new OracleConnector();
    private static OracleSQL oracleSQL = new OracleSQL();
    
    public static void main(String[] args) throws SQLException {
        String server = "ftp.*****.com";
        int port = 21;
        String user = "*****";
        String pass = "*****";
 
        oracleSQL.flush();
        
        FTPClient ftpClient = new FTPClient();
        try {
            
            //Connection to FTP server
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            //Download "al63c1.xml" file (= Vehicule informations)
            String remoteFile1 = "/datas/al63c1.xml";
            File downloadFile1 = new File("al63c1.xml");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
 
            if (success) {
                System.out.println("XML file (al63c1.xml) has been downloaded successfully.\n");
            }
            
            JDOM2 jdom2 = new JDOM2("al63c1.xml");
            
            /*for(Vehicule v : jdom2.getListeVehicule2()){                
                System.out.println(v.IdentifiantVehicule+ " :\n");
                for(String photo : v.Photos){
                    System.out.println(photo+"\n");
                }
            }*/
            
            oracleSQL.addVehiculeInDB(jdom2.getListeVehicule2());    
            
            //Download "arv.xml" file (= Vehicule informations)
            String remoteFile3 = "/datas/arv.xml";
            File downloadFile3 = new File("arv.xml");
            OutputStream outputStream3 = new BufferedOutputStream(new FileOutputStream(downloadFile3));
            boolean success3 = ftpClient.retrieveFile(remoteFile3, outputStream3);
            outputStream3.close();
 
            if (success3) {
                System.out.println("XML file (arv.xml) has been downloaded successfully.\n");
            }
            
            JDOM2 jdom3 = new JDOM2("arv.xml");     
            
            
            oracleSQL.addVehiculeInDB(jdom3.getListeVehicule2());   
            
            //Download "jt03m1.xml" file (= Vehicule informations)
            String remoteFile4 = "/datas/jt03m1.xml";
            File downloadFile4 = new File("jt03m1.xml");
            OutputStream outputStream4 = new BufferedOutputStream(new FileOutputStream(downloadFile4));
            boolean success4 = ftpClient.retrieveFile(remoteFile4, outputStream4);
            outputStream4.close();
 
            if (success4) {
                System.out.println("XML file (jt03m1.xml) has been downloaded successfully.\n");
            }
            
            JDOM2 jdom4 = new JDOM2("jt03m1.xml");     
            
            
            oracleSQL.addVehiculeInDB(jdom4.getListeVehicule2());   
            
            
            //Download "jt48m1.xml" file (= Vehicule informations)
            String remoteFile5 = "/datas/jt48m1.xml";
            File downloadFile5 = new File("jt48m1.xml");
            OutputStream outputStream5 = new BufferedOutputStream(new FileOutputStream(downloadFile5));
            boolean success5 = ftpClient.retrieveFile(remoteFile5, outputStream5);
            outputStream5.close();
 
            if (success5) {
                System.out.println("XML file (jt48m1.xml) has been downloaded successfully.\n");
            }
            
            JDOM2 jdom5 = new JDOM2("jt48m1.xml");     
            
          
            oracleSQL.addVehiculeInDB(jdom5.getListeVehicule2());   
            
            
            
            //Download "photo.txt.zip" archive
            ftpClient.setFileTransferMode(FTPClient.BLOCK_TRANSFER_MODE);
            String remoteFile2 = "/datas/photos.txt.zip";
            File downloadFile2 = new File("photos.txt.zip");
            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
            boolean success2 = ftpClient.retrieveFile(remoteFile2, outputStream2);
            outputStream2.close();
 
            if (success2) {
                System.out.println("Photo ZIP has been downloaded successfully.\n");
                
                // File (or directory) with old name
                File file = new File("unzip/photos.txt");

                // File (or directory) with new name
                File file2 = new File("unzip/photosOld.txt");

                if (file2.exists()){                
                   file2.delete();
                }

                // Rename file (or directory)
                boolean successRename = file.renameTo(file2);

                if (!successRename) {
                   // File was not successfully renamed
                }
                
                //Unzip "photos.txt.zip" archive in folder "unzip"
                UnZip unZip = new UnZip();
                unZip.unZipIt("photos.txt.zip", "unzip");
            } 
            
            //Create folder "Photos" if doesn't exist
            File folder = new File("Photos");
            if(!folder.exists()){
                    folder.mkdir();
            }
                       
            //Read file "photos.txt"
            PhotosDownload photosDownload = new PhotosDownload("unzip/photos.txt");
            
            String[][] listePhotos = photosDownload.getListePhotos();
            
            //Read file "photosOld.txt" if exist
            File file2 = new File("unzip/photosOld.txt");
            if (file2.exists()){       
                PhotosDownload photosDownloadOld = new PhotosDownload("unzip/photosOld.txt");

                String[][] listePhotosOld = photosDownloadOld.getListePhotos();
                
                Boolean existe = false;
                //Download pictures with old file
                for(int i = 0; i<photosDownload.nbPhotos; i++){
                    existe = false;
                    for(int j = 0; j<photosDownloadOld.nbPhotos; j++){
                        if(listePhotosOld[i][0]==listePhotos[j][0] &&listePhotosOld[i][2]==listePhotos[j][2]){
                            existe = true;
                        }                        
                    }
                    if(existe){
                        /*String remoteFile6 = listePhotos[i][1];
                        File downloadFile6 = new File("Photos" + File.separator + listePhotos[i][0]);
                        OutputStream outputStream6 = new BufferedOutputStream(new FileOutputStream(downloadFile6));
                        boolean success6 = ftpClient.retrieveFile(remoteFile6, outputStream6);
                        outputStream6.close();*/
                        //System.out.println("Photo "+listePhotos[i][0]+" téléchargée !");
                    }
                    else{                        
                        //System.out.println("La photo existe déjà");
                    }
                } 
            }
            else{
                //Download pictures with no old file
                for(int i = 0; i<photosDownload.nbPhotos; i++){
                    String remoteFile6 = listePhotos[i][1];
                    File downloadFile6 = new File("Photos" + File.separator + listePhotos[i][0]);
                    OutputStream outputStream6 = new BufferedOutputStream(new FileOutputStream(downloadFile6));
                    boolean success6 = ftpClient.retrieveFile(remoteFile6, outputStream6);
                    outputStream6.close();
                } 
            }
            
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}