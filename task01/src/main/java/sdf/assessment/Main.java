package sdf.assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//"C:/Users/kevin/sdf-assessment/task01/static/thankyou.csv"

public class Main
{

    public static void main(String[] args) throws Exception  
    {
        
        File f = new File("C:/Users/kevin/sdf-assessment/task01/static/thankyou.csv");
        if(args.length>0)
        f = new File(args[0]);   
        String line = "";  
        String[] tempArr;
        String newFile = args[1];
        FileWriter writer = new FileWriter(newFile);
        try{
        BufferedReader br = new BufferedReader(new FileReader(f));  
        while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
                tempArr = line.split(",");
                //System.out.println(content);
                
                writer.write(tempArr[2] + "\n\n" + "Dear " + tempArr[0] + "\n\n" + 
                "Thank you for staying with us over these " + tempArr[3] + " years.\n\n");
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