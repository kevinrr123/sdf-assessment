package sdf.assessment2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


//java -cp target/task02-1.0-SNAPSHOT.jar sdf.assessment2.Main

public class Main
{
    public static void main( String[] args )
    {

        System.out.println("Client!!");
        // Creating Socket class object and initializing Socket
        boolean stop = false;
        InputStream is = null;
        ObjectInputStream dis = null;
        Socket socket = null;
        OutputStream os = null;
 
        // Try block to check if exception occurs (OutputStream os= socket.getOutputStream())
        try {
            while(!stop){
            String response = null;
            //Not required anymore - String input = cons.readLine("to server> ");
            socket = new Socket("task02.chuklee.com", 80);
            socket.setSoTimeout(15*1000);
            os = socket.getOutputStream();     
            is = socket.getInputStream();
            ObjectOutputStream dos = new ObjectOutputStream(os);    
            dis = new ObjectInputStream(is);

            try{
                response = dis.readUTF();
                System.out.println(response+"\n");
                String[] newResponse = response.split(" ");
                System.out.println(newResponse[0]);
                String[] NumList = newResponse[1].split(",");
                int size = NumList.length;
                int[] intArr = new int[size];
                for(int i=0; i<size; i++) {
                    intArr[i] = Integer.parseInt(NumList[i]);
                    }
                float total = 0;
                for(int i=0; i<intArr.length; i++){
                    total = total + intArr[i];
                }
                float average = total / intArr.length;
                System.out.println(intArr.length);
                System.out.println(average+"\n");

                dos.writeUTF(newResponse[0]);
                dos.writeUTF("Kevin Richard Raja");
                dos.writeUTF("kevin.richard.r.7@gmail.com");
                dos.writeFloat(average);
                dos.flush();
                os.flush();
                

                Boolean responseSec;
                responseSec = dis.readBoolean();
                System.out.println(responseSec);

                    if(responseSec){
                        System.out.println("SUCCESS");
                        stop = true;
                        os.close();
                        is.close();                       
                        socket.close();
                    } else if(!responseSec){
                        String Error = dis.readUTF();
                        os.close();
                        is.close();                       
                        socket.close();
                        System.out.println("FAILED\n");
                        System.out.println(Error);
                    }

                }catch(EOFException e){
                    // suppress if the reading is called twice.
                }

            }
    

        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    
    }
}