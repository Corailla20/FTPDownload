/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpdownload;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Corailla20
 */
public class Vehicule {

  String CodePvo;
  String SocieteNom;
  String SocieteMarque;
  String SocieteAdresse;
  String SocieteAdresseSuite;
  int SocieteCodePostal;
  String SocieteVille;
  String ContactsNoms;
  String ContactsTelephones;
  String ContactsTelephones2;
  String ContactsEmails;
  String IdentifiantVehicule;
  String ReferenceVehicule;
  String NumeroPolice;
  String StatutStock;
  int Annee;
  String Date1Mec;
  String GenreLibelle;
  String Marque;
  String Famille;
  String Version;
  String Modele;
  String TypeMine;
  String EnergieLibelle;
  int PuissanceFiscale;
  int PuissanceReelle;
  int Cylindree;
  int NbPlaces;
  int NbPortes;
  int Kilometrage;
  String KmGaranti;
  String Couleur;
  String BoiteLibelle;
  int NbRapports;
  float PrixVenteTTC;
  boolean PremiereMain;
  String GarantieLibelle;
  String DestinationLibelle;
  String CategorieLibelle;
  String EquipementsSerieEtOption;
  String SiteLibelle;
  String LieuLibelle;
  String Photos;
  int Co2;
  String CommentairePublic;
  int Poids;
  int PTAC;
  int PTRA;
  int ChargeUtile;
  int Longueur;
  int Largeur;
  int Empattement;
  int Hauteur;
  int Volume;
  String Silhouette;
  String DerniereVisiteTechnique;
  String DateControlographe;
  int AgeStock;

    public Vehicule(String CodePvo, String SocieteNom, String SocieteMarque, String SocieteAdresse, String SocieteAdresseSuite, int SocieteCodePostal, String SocieteVille, String ContactsNoms, String ContactsTelephones, String ContactsTelephones2, String ContactsEmails, String IdentifiantVehicule, String ReferenceVehicule, String NumeroPolice, String StatutStock, int Annee, String Date1Mec, String GenreLibelle, String Marque, String Famille, String Version, String Modele, String TypeMine, String EnergieLibelle, int PuissanceFiscale, int PuissanceReelle, int Cylindree, int NbPlaces, int NbPortes, int Kilometrage, String KmGaranti, String Couleur, String BoiteLibelle, int NbRapports, float PrixVenteTTC, boolean PremiereMain, String GarantieLibelle, String DestinationLibelle, String CategorieLibelle, String EquipementsSerieEtOption, String SiteLibelle, String LieuLibelle, String Photos, int Co2, String CommentairePublic, int Poids, int PTAC, int PTRA, int ChargeUtile, int Longueur, int Largeur, int Empattement, int Hauteur, int Volume, String Silhouette, String DerniereVisiteTechnique, String DateControlographe, int AgeStock) throws FileNotFoundException {
        this.CodePvo = CodePvo.replace("'", "`");
        this.SocieteNom = SocieteNom.replace("'", "`");
        this.SocieteMarque = SocieteMarque.replace("'", "`");
        this.SocieteAdresse = SocieteAdresse.replace("'", "`");
        this.SocieteAdresseSuite = SocieteAdresseSuite.replace("'", "`");
        this.SocieteCodePostal = SocieteCodePostal;
        this.SocieteVille = SocieteVille.replace("'", "`");
        this.ContactsNoms = ContactsNoms.replace("'", "`");
        this.ContactsTelephones = ContactsTelephones.replace("'", "`");
        this.ContactsTelephones2 = ContactsTelephones2.replace("'", "`");
        this.ContactsEmails = ContactsEmails.replace("'", "`");
        this.IdentifiantVehicule = IdentifiantVehicule.replace("'", "`");
        this.ReferenceVehicule = ReferenceVehicule.replace("'", "`");
        this.NumeroPolice = NumeroPolice.replace("'", "`");
        this.StatutStock = StatutStock.replace("'", "`");
        this.Annee = Annee;
        this.Date1Mec = Date1Mec.replace("'", "`");
        this.GenreLibelle = GenreLibelle.replace("'", "`");
        this.Marque = Marque.replace("'", "`");
        this.Famille = Famille.replace("'", "`");
        this.Version = Version.replace("'", "`");
        this.Modele = Modele.replace("'", "`");
        this.TypeMine = TypeMine.replace("'", "`");
        this.EnergieLibelle = EnergieLibelle.replace("'", "`");
        this.PuissanceFiscale = PuissanceFiscale;
        this.PuissanceReelle = PuissanceReelle;
        this.Cylindree = Cylindree;
        this.NbPlaces = NbPlaces;
        this.NbPortes = NbPortes;
        this.Kilometrage = Kilometrage;
        this.KmGaranti = KmGaranti.replace("'", "`");
        this.Couleur = Couleur.replace("'", "`");
        this.BoiteLibelle = BoiteLibelle.replace("'", "`");
        this.NbRapports = NbRapports;
        this.PrixVenteTTC = PrixVenteTTC;
        this.PremiereMain = PremiereMain;
        this.GarantieLibelle = GarantieLibelle.replace("'", "`");
        this.DestinationLibelle = DestinationLibelle.replace("'", "`");
        this.CategorieLibelle = CategorieLibelle.replace("'", "`");
        this.EquipementsSerieEtOption = EquipementsSerieEtOption.replace("'", "`");
        this.SiteLibelle = SiteLibelle.replace("'", "`");
        this.LieuLibelle = LieuLibelle.replace("'", "`");
        this.Photos = parsePhotos(Photos);
        //this.Photos = Photos;
        this.Co2 = Co2;
        this.CommentairePublic = CommentairePublic.replace("'", "`");
        this.Poids = Poids;
        this.PTAC = PTAC;
        this.PTRA = PTRA;
        this.ChargeUtile = ChargeUtile;
        this.Longueur = Longueur;
        this.Largeur = Largeur;
        this.Empattement = Empattement;
        this.Hauteur = Hauteur;
        this.Volume = Volume;
        this.Silhouette = Silhouette.replace("'", "`");
        this.DerniereVisiteTechnique = DerniereVisiteTechnique.replace("'", "`");
        this.DateControlographe = DateControlographe.replace("'", "`");
        this.AgeStock = AgeStock;
    }
    
    @Override
    public String toString() {
        return "Vehicule{" + "CodePvo=" + CodePvo + ", SocieteNom=" + SocieteNom + ", SocieteMarque=" + SocieteMarque + ", SocieteAdresse=" + SocieteAdresse + ", SocieteAdresseSuite=" + SocieteAdresseSuite + ", SocieteCodePostal=" + SocieteCodePostal + ", SocieteVille=" + SocieteVille + ", ContactsNoms=" + ContactsNoms + ", ContactsTelephones=" + ContactsTelephones + ", ContactsTelephones2=" + ContactsTelephones2 + ", ContactsEmails=" + ContactsEmails + ", IdentifiantVehicule=" + IdentifiantVehicule + ", ReferenceVehicule=" + ReferenceVehicule + ", NumeroPolice=" + NumeroPolice + ", StatutStock=" + StatutStock + ", Annee=" + Annee + ", Date1Mec=" + Date1Mec + ", GenreLibelle=" + GenreLibelle + ", Marque=" + Marque + ", Famille=" + Famille + ", Version=" + Version + ", Modele=" + Modele + ", TypeMine=" + TypeMine + ", EnergieLibelle=" + EnergieLibelle + ", PuissanceFiscale=" + PuissanceFiscale + ", PuissanceReelle=" + PuissanceReelle + ", Cylindree=" + Cylindree + ", NbPlaces=" + NbPlaces + ", NbPortes=" + NbPortes + ", Kilometrage=" + Kilometrage + ", KmGaranti=" + KmGaranti + ", Couleur=" + Couleur + ", BoiteLibelle=" + BoiteLibelle + ", NbRapports=" + NbRapports + ", PrixVenteTTC=" + PrixVenteTTC + ", PremiereMain=" + PremiereMain + ", GarantieLibelle=" + GarantieLibelle + ", DestinationLibelle=" + DestinationLibelle + ", CategorieLibelle=" + CategorieLibelle + ", EquipementsSerieEtOption=" + EquipementsSerieEtOption + ", SiteLibelle=" + SiteLibelle + ", LieuLibelle=" + LieuLibelle + ", Photos=" + Photos + ", Co2=" + Co2 + ", CommentairePublic=" + CommentairePublic + ", Poids=" + Poids + ", PTAC=" + PTAC + ", PTRA=" + PTRA + ", ChargeUtile=" + ChargeUtile + ", Longueur=" + Longueur + ", Largeur=" + Largeur + ", Empattement=" + Empattement + ", Hauteur=" + Hauteur + ", Volume=" + Volume + ", Silhouette=" + Silhouette + ", DerniereVisiteTechnique=" + DerniereVisiteTechnique + ", DateControlographe=" + DateControlographe + '}';
    }
    
    public String parsePhotos(String photo) throws FileNotFoundException{
        String[] need = photo.split("\\|");
        ArrayList<String> photo2 = new ArrayList<>();
        String photo3 = null;
        
        if(!photo.isEmpty()){
            PhotosDownload photosDownload = new PhotosDownload("unzip/photos.txt");

            String[][] listePhotos = photosDownload.getListePhotos();   

            for(int j = 0; j<need.length ; j++){
                for(int i = 0; i<=photosDownload.nbPhotos; i++){            
                    if(need[j].equals(listePhotos[i][0])){
                        photo2.add(listePhotos[i][1]);
                        System.out.println(listePhotos[i][1]);
                    }
                }
            }
            if(!(photo2.isEmpty())){
                photo3 = photo2.get(0);
                System.out.println("Size : "+photo2.size());
                for(int k = 1; k<photo2.size() ; k++){ 
                    photo3 = photo3 + "|" +photo2.get(k);
                    System.out.println("Photo :"+photo2.get(k));
                }     
            }
        }
        System.out.println("Résultat : "+photo3);
        return photo3;
    } 
  
}
