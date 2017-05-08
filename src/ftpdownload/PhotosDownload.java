/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpdownload;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Corailla20
 */
public class PhotosDownload {
    
    
    private String[][] listePhotos = new String[5000][3];

    public String[][] getListePhotos() {
        return listePhotos;
    }
    
    public int nbPhotos;   
    
    public PhotosDownload(String path) throws FileNotFoundException{
        
        int i = 0;
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                listePhotos[i] = line.split("\t");
                
                //System.out.println(i+" :");
                
                for(int j = 0; j<=2; j++){
                    //System.out.println(listePhotos[i][j]);
                }               
                
                i++;
                
            }
            String everything = sb.toString();
            nbPhotos= i-1;
            System.out.println("-------------------------"+nbPhotos+"---------------------------");
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
    
}
