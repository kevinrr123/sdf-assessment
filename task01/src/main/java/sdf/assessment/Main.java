package sdf.assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//"C:/Users/kevin/sdf-assessment/task01/static/thankyou.csv"

public class Main
{

    public static void main(String[] args) throws Exception  
    {
        
        File f = new File("C:/Users/kevin/sdf-assessment/task01/static/thankyou.csv");
        if(args.length>0)
        f = new File(args[0]);   
        String line = "";
        String oldContent = "";
        String[] tempArr = new String[10];
        String txtFile = args[1];
        List<String> wordList = new ArrayList<String>();;
        FileWriter writer = new FileWriter("output.txt");
        try{
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedReader br2 = new BufferedReader(new FileReader(txtFile));  
            while ((line = br.readLine()) != null)    
                    {  
                        tempArr = line.split(",");
                        wordList = Arrays.asList(tempArr);
                        for (String e : wordList) {  
                            System.out.println(e); 
                        //writer.write(tempArr[2] + "\n\n" + "Dear " + tempArr[0] + "\n\n" + 
                        //"Thank you for staying with us over these " + tempArr[3] + " years.\n\n");
                        }
                    }
  
                String line2 = br2.readLine();

                while (line2 != null){
                    oldContent = oldContent + line2 + System.lineSeparator();
                    line2 = br2.readLine();
                }
                for (String newFile : wordList) {
                    for(int i=0;i<tempArr.length;i++){
                            String newContent = oldContent.replace("__", tempArr[i]);
                            writer.write(newContent);
                        }
                }
                    writer.write("Done");
                    writer.close();
                        
        }catch (IOException e)   
            {  
            e.printStackTrace();  
            }
    }             
        
} 
    
  