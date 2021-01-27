package com.psl.training.billGeneration;
import java.io.*;

 

public class BillGenerator {

 

    public void generateBill(String label, String name) {
//        File file = new File(name+".txt");
//        file.createNewFile();
        
        try (FileWriter writer = new FileWriter(name+".txt", true)){
            writer.write(label);
        } catch (FileNotFoundException f) {
            // TODO Auto-generated catch block
            f.printStackTrace(); 
        } catch (IOException e ){
            e.printStackTrace();
        }
    }

 

}