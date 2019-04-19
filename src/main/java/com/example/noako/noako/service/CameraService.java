package com.example.noako.noako.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CameraService {



    private static Process p;

    public CameraService(){
        
        
    }
    
    
    public String DestroySession(){
        try{
            p.destroy();
            return "Destroyed";
        }catch(Exception exception){
            System.out.println("Cannot destroy the session");
            return "Error in destroying";
        }
       
    }



    public String executeCode (){



    String s = null;

    ArrayList<String> array = new ArrayList<>();
    array.add(" workon cv");
    array.add("  python /home/dinalie/Downloads/pi-face-recognition/pi_face_recognition.py --cascade /home/dinalie/Downloads/pi-face-recognition/haarcascade_frontalface_default.xml --encodings /home/dinalie/Downloads/pi-face-recognition/encodings.pickle");


    try {

       // for(String com : array){
        
    // run the Unix "ps -ef" command
        // using the Runtime exec method:
        p = Runtime.getRuntime().exec(array.get(1));
    
        
        BufferedReader stdInput = new BufferedReader(new 
             InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new 
             InputStreamReader(p.getErrorStream()));

        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        
        // read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }

        System.exit(0);
        
        return "Camera start successfull";
       
    //}
    }
    catch (IOException e) {
        System.out.println("exception happened - here's what I know: ");
        e.printStackTrace();
        //System.exit(-1);
        return "Camera failed";
    }

    
}















}
