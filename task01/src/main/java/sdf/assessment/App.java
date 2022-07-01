package sdf.assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;  

public class App 
{

    public static void main(String[] args) throws Exception  
    {
        File f = new File("C:/Users/kevin/sdf-assessment/task01/static/thankyou.csv");   
        String line = "";  
        List<String[]> content = new ArrayList<>();
        String[] tempArr;
        FileWriter writer = new FileWriter("output.txt");
        try{
        BufferedReader br = new BufferedReader(new FileReader(f));  
        while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
                content.add(line.split(","));
                tempArr = line.split(",");
                //System.out.println(content);
                for (String str : tempArr) {
                writer.write(str + " ");
                }
                writer.write("\n");
            }
            writer.close();
                //String[] item = line.split(",");    // use comma as separator  
                //System.out.println(item[2]);
                //System.out.println("");
                //System.out.println("Dear " + item[0] );
                //System.out.println("");
                //System.out.println("Thank you for staying with us over these " + item[3] + " years.");
                //System.out.println("");        
                
            }     
            catch (IOException e)   
        {  
            e.printStackTrace();  
        }             
 
    } 
    
}  