
package dosyalama.islemleri;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.objects.NativeRegExp;


public class Islemler {
        degiskenler degisken=new degiskenler();
        ArrayList<String> gecici=new ArrayList<>();
     public void dosyaOlustur(String okuma){
        File dosya=new File("C:\\dosyalama\\"+okuma+".txt");
        if(!dosya.exists())
        {
            
            try {
                dosya.createNewFile();
            } catch (Exception e) {
                System.out.println("Dosya oluşturma hatası ... ");
            }
            
        }else
        {
            JOptionPane.showMessageDialog(null, "Aynı kayıt bulunmaktadır ....");
        }
    }
     
     public void dosyayaKaydet(String il,String ilce){
         try {
         FileWriter yaz=new FileWriter("c:\\dosyalama\\"+il+".txt",true); 
         yaz.append(ilce+System.lineSeparator());
         yaz.close();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "İlçe Kaydetme Hatası");
         }
    }
     public void dosyaSil(String sil){
        File[] files=new File("C:\\dosyalama").listFiles();
        for (File file : files) 
        {
            if(file.getName().endsWith(".txt")){
             if(file.getName().contains(sil))
                file.delete();
            }
        }
       
     }
     public DefaultComboBoxModel comboBoxListele(){
        DefaultComboBoxModel combo=new DefaultComboBoxModel();
        
        File[] files=new File("C:\\dosyalama").listFiles();
        for (File file : files) 
        {
            
            if(file.getName().endsWith(".txt"))
                
                combo.addElement(file.getName().replace(".txt",""));
       }
       return combo;
     }
     public DefaultComboBoxModel comboBox2Listele(String combo1){
         DefaultComboBoxModel combo2model=new DefaultComboBoxModel();
         
         try {  
                
                File combo2=new File("C:\\dosyalama\\"+combo1+".txt");
                Scanner input=new Scanner(combo2);
                while (input.hasNextLine()){
                combo2model.addElement(input.nextLine());
                }
                input.close();
            } catch (Exception e) {
            }
         return combo2model;
     }
     public void ilceSil(String combobox1,String combobox2){
         
         try {
         File combo2=new File("C:\\dosyalama\\"+combobox1+".txt");
         FileWriter yaz=new FileWriter("C:\\dosyalama\\"+combobox1+".txt",true);
         
         Scanner input=new Scanner(combo2);
         String ata;
         int geciciIndexBul = 0;
         while (input.hasNextLine()) {
             ata=input.nextLine();
             gecici.add(ata);
             }
         input.close();
              } catch (Exception e) {
             System.out.println("Hata Var");
             e.printStackTrace();
         }
                int size = gecici.size();
                for (int i = size - 1; i >= 0; i--) {
                if(gecici.get(i).equals(combobox2)){
                gecici.remove(i);
                    try {
                        FileWriter yaz=new FileWriter("C:\\dosyalama\\"+combobox1+".txt");
                        for (String gecici1 : gecici) {
                            yaz.append(gecici1+System.lineSeparator());    
                        }
                                              
                        yaz.close();
                        
                        
                    } catch (Exception e) {
                    }
                          }
                    }gecici.clear();
         }
     
     
     
}
