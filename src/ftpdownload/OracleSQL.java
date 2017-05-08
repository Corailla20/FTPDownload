/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpdownload;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Corailla20
 */
public class OracleSQL {
    
    private static final OracleConnector connecteur = OracleConnector.getInstance();
    
    public void flush() throws SQLException{
        connecteur.exec("DELETE FROM vehicule2");
        connecteur.exec("COMMIT WORK");
    }
    
    public void addVehiculeInDB(ArrayList<Vehicule> listeVehicules) throws SQLException{
        int i = 1;
        ArrayList<String> listeID = connecteur.execSelectColonne("SELECT identifiantVehicule FROM vehicule2");
        for(Vehicule v : listeVehicules){
            System.out.println(i+"\n");
            i++;
            
            if(!listeID.contains(v.IdentifiantVehicule)){
                int premiereMain = 0; //0=Faux
                if(v.PremiereMain){
                    premiereMain = 1;
                }
                if(v.EquipementsSerieEtOption.length() > 2850) {
                    String equipement1 = v.EquipementsSerieEtOption.substring(0,2850);
                    String equipement2 = v.EquipementsSerieEtOption.substring(2850);
                    
                    connecteur.exec("INSERT INTO VEHICULE2 VALUES ('"+v.IdentifiantVehicule
                            +"','"+v.CodePvo
                            +"','"+v.SocieteNom
                            +"','"+v.SocieteMarque
                            +"','"+v.SocieteAdresse
                            +"','"+v.SocieteAdresseSuite
                            +"',"+v.SocieteCodePostal
                            +",'"+v.SocieteVille
                            +"','"+v.ContactsNoms
                            +"','"+v.ContactsTelephones
                            +"','"+v.ContactsTelephones2
                            +"','"+v.ContactsEmails
                            +"','"+v.ReferenceVehicule
                            +"','"+v.NumeroPolice
                            +"','"+v.StatutStock
                            +"',"+v.Annee
                            +",'"+v.Date1Mec
                            +"','"+v.GenreLibelle
                            +"','"+v.Marque
                            +"','"+v.Famille
                            +"','"+v.Version
                            +"','"+v.Modele
                            +"','"+v.TypeMine
                            +"','"+v.EnergieLibelle
                            +"',"+v.PuissanceFiscale
                            +","+v.PuissanceReelle
                            +","+v.Cylindree
                            +","+v.NbPlaces
                            +","+v.NbPortes
                            +","+v.Kilometrage
                            +",'"+v.KmGaranti
                            +"','"+v.Couleur
                            +"','"+v.BoiteLibelle
                            +"',"+v.NbRapports
                            +","+v.PrixVenteTTC
                            +","+premiereMain
                            +",'"+v.GarantieLibelle
                            +"','"+v.DestinationLibelle
                            +"','"+v.CategorieLibelle
                            +"','"+equipement1
                            +"','"+v.SiteLibelle
                            +"','"+v.LieuLibelle
                            +"',"+v.Co2
                            +",'"+v.CommentairePublic
                            +"',"+v.Poids
                            +","+v.PTAC
                            +","+v.PTRA
                            +","+v.ChargeUtile
                            +","+v.Longueur
                            +","+v.Largeur
                            +","+v.Empattement
                            +","+v.Hauteur
                            +","+v.Volume
                            +",'"+v.Silhouette
                            +"','"+v.DerniereVisiteTechnique
                            +"','"+v.DateControlographe
                            +"','"+v.Photos
                            +"','"+v.AgeStock
                            +"','"+equipement2
                            +"')");
                }
                else {
                    connecteur.exec("INSERT INTO VEHICULE2 VALUES ('"+v.IdentifiantVehicule
                            +"','"+v.CodePvo
                            +"','"+v.SocieteNom
                            +"','"+v.SocieteMarque
                            +"','"+v.SocieteAdresse
                            +"','"+v.SocieteAdresseSuite
                            +"',"+v.SocieteCodePostal
                            +",'"+v.SocieteVille
                            +"','"+v.ContactsNoms
                            +"','"+v.ContactsTelephones
                            +"','"+v.ContactsTelephones2
                            +"','"+v.ContactsEmails
                            +"','"+v.ReferenceVehicule
                            +"','"+v.NumeroPolice
                            +"','"+v.StatutStock
                            +"',"+v.Annee
                            +",'"+v.Date1Mec
                            +"','"+v.GenreLibelle
                            +"','"+v.Marque
                            +"','"+v.Famille
                            +"','"+v.Version
                            +"','"+v.Modele
                            +"','"+v.TypeMine
                            +"','"+v.EnergieLibelle
                            +"',"+v.PuissanceFiscale
                            +","+v.PuissanceReelle
                            +","+v.Cylindree
                            +","+v.NbPlaces
                            +","+v.NbPortes
                            +","+v.Kilometrage
                            +",'"+v.KmGaranti
                            +"','"+v.Couleur
                            +"','"+v.BoiteLibelle
                            +"',"+v.NbRapports
                            +","+v.PrixVenteTTC
                            +","+premiereMain
                            +",'"+v.GarantieLibelle
                            +"','"+v.DestinationLibelle
                            +"','"+v.CategorieLibelle
                            +"','"+v.EquipementsSerieEtOption
                            +"','"+v.SiteLibelle
                            +"','"+v.LieuLibelle
                            +"',"+v.Co2
                            +",'"+v.CommentairePublic
                            +"',"+v.Poids
                            +","+v.PTAC
                            +","+v.PTRA
                            +","+v.ChargeUtile
                            +","+v.Longueur
                            +","+v.Largeur
                            +","+v.Empattement
                            +","+v.Hauteur
                            +","+v.Volume
                            +",'"+v.Silhouette
                            +"','"+v.DerniereVisiteTechnique
                            +"','"+v.DateControlographe
                            +"','"+v.Photos
                            +"','"+v.AgeStock
                            +"','"+""
                            +"')");
                }
            }
            else {
                System.out.println(v.IdentifiantVehicule+" existe déjà dans la DB");
            }
        }
    }
    
}
