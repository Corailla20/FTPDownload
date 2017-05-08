/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftpdownload;

import java.io.*;
import java.util.ArrayList;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.filter.*;
import java.util.List;
import java.util.Iterator;

public class JDOM2
{
   private static org.jdom2.Document document;
   private static Element racine;
   private static ArrayList<Vehicule> listeVehicule2 = new ArrayList<>();

    public static ArrayList<Vehicule> getListeVehicule2() {
        return listeVehicule2;
    }

   public JDOM2(String path) throws FileNotFoundException
   {
      //On crée une instance de SAXBuilder
      SAXBuilder sxb = new SAXBuilder();
      try
      {
         //On crée un nouveau document JDOM avec en argument le fichier XML
         //Le parsing est terminé ;)
         document = sxb.build(new File(path));
      }
      catch(Exception e){}

      //On initialise un nouvel élément racine avec l'élément racine du document.
      racine = document.getRootElement();

      //Méthode définie dans la partie 3.2. de cet article
      //afficheALL();
      createAll();
      
      int i = 1;
      
      /*for(Vehicule v : listeVehicule2){
          System.out.println("Véhicule n°"+i+" -> "+v.toString());
          i++;
      }*/
   }
   
   static void afficheALL()
    {
       //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
       List listeVehicule = racine.getChildren("Vehicule");

       //On crée un Iterator sur notre liste
       Iterator i = listeVehicule.iterator();
       while(i.hasNext())
       {
          //On recrée l'Element courant à chaque tour de boucle afin de
          //pouvoir utiliser les méthodes propres aux Element comme :
          //sélectionner un nœud fils, modifier du texte, etc...
          Element courant = (Element)i.next();
          //On affiche le nom de l’élément courant
          System.out.println(courant.getChild("Marque").getText()+" "+courant.getChild("Famille").getText()+" "+courant.getChild("Version").getText()+"\n");
       }
    }
   
   static void createAll() throws FileNotFoundException
    {
       List listeVehicule = racine.getChildren("Vehicule");

       Iterator i = listeVehicule.iterator();
       while(i.hasNext())
       {
          Element courant = (Element)i.next();
          
          boolean premiereMain = false;
          
          if(courant.getChild("PremiereMain").getText() == "FAUX"){
              premiereMain = false;
          }
          else if(courant.getChild("PremiereMain").getText() == "VRAI"){
              premiereMain = true;
          }
          
          if(!courant.getChild("DestinationLibelle").getText().equals("Destruction")){          
            listeVehicule2.add(new Vehicule(courant.getChild("CodePvo").getText(),
                    courant.getChild("SocieteNom").getText(),
                    courant.getChild("SocieteMarque").getText(),
                    courant.getChild("SocieteAdresse").getText(),
                    courant.getChild("SocieteAdresseSuite").getText(),
                    tryParseInt(courant.getChild("SocieteCodePostal").getText()),
                    courant.getChild("SocieteVille").getText(),
                    courant.getChild("ContactsNoms").getText(),
                    courant.getChild("ContactsTelephones").getText(),
                    courant.getChild("ContactsTelephones2").getText(),
                    courant.getChild("ContactsEmails").getText(),
                    courant.getChild("IdentifiantVehicule").getText(),
                    courant.getChild("ReferenceVehicule").getText(),
                    courant.getChild("NumeroPolice").getText(),
                    courant.getChild("StatutStock").getText(),
                    tryParseInt(courant.getChild("Annee").getText()),
                    courant.getChild("Date1Mec").getText(),
                    courant.getChild("GenreLibelle").getText(),
                    courant.getChild("Marque").getText(),
                    courant.getChild("Famille").getText(),
                    courant.getChild("Version").getText(),
                    courant.getChild("Modele").getText(),
                    courant.getChild("TypeMine").getText(),
                    courant.getChild("EnergieLibelle").getText(),
                    tryParseInt(courant.getChild("PuissanceFiscale").getText()),
                    tryParseInt(courant.getChild("PuissanceReelle").getText()),
                    tryParseInt(courant.getChild("Cylindree").getText()),
                    tryParseInt(courant.getChild("NbPlaces").getText()),
                    tryParseInt(courant.getChild("NbPortes").getText()),
                    tryParseInt(courant.getChild("Kilometrage").getText()),
                    courant.getChild("KmGaranti").getText(),
                    courant.getChild("Couleur").getText(),
                    courant.getChild("BoiteLibelle").getText(),
                    tryParseInt(courant.getChild("NbRapports").getText()),
                    Float.valueOf(courant.getChild("PrixVenteTTC").getText()),
                    premiereMain,
                    courant.getChild("GarantieLibelle").getText(),
                    courant.getChild("DestinationLibelle").getText(),
                    courant.getChild("CategorieLibelle").getText(),
                    courant.getChild("EquipementsSerieEtOption").getText(),
                    courant.getChild("SiteLibelle").getText(),
                    courant.getChild("LieuLibelle").getText(),
                    courant.getChild("Photos").getText(),
                    tryParseInt(courant.getChild("Co2").getText()),
                    courant.getChild("CommentairePublic").getText(),
                    tryParseInt(courant.getChild("Poids").getText()),
                    tryParseInt(courant.getChild("PTAC").getText()),
                    tryParseInt(courant.getChild("PTRA").getText()),
                    tryParseInt(courant.getChild("ChargeUtile").getText()),
                    tryParseInt(courant.getChild("Longueur").getText()),
                    tryParseInt(courant.getChild("Largeur").getText()),
                    tryParseInt(courant.getChild("Empattement").getText()),
                    tryParseInt(courant.getChild("Hauteur").getText()),
                    tryParseInt(courant.getChild("Volume").getText()),
                    courant.getChild("Silhouette").getText(),
                    courant.getChild("DerniereVisiteTechnique").getText(),
                    courant.getChild("DateControlographe").getText(),
                    tryParseInt(courant.getChild("AgeStock").getText())
            ));          
          }
        }
    }
   
   static int tryParseInt(String value) { 
    try {  
        return Integer.parseInt(value);  
     } catch(NumberFormatException nfe) {  
         // Log exception.
         return 0;
     }  
   }
}