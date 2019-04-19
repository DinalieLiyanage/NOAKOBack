package com.example.noako.noako.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.example.noako.noako.service.CameraService;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("api")
public class NoakoController{

static CameraService cameraService;

static Thread thread;



@ResponseBody
@RequestMapping(value = "/begin" , method = RequestMethod.GET)
public String Starter() {

        cameraService = new CameraService();

       NoakoController.threading();
      return "Cam start";


        

       // return cameraService.startCamera(); 
}

   

public static void threading (){
        Runnable t = new Runnable() {
    
        @Override
        public void run() {
           cameraService.executeCode(); 
        }
    };

    thread =new Thread(t);
    thread.start();

}


@ResponseBody
@RequestMapping(value = "/destroy", method = RequestMethod.GET)
public String Destroyer(){


    thread.stop();
    return cameraService.DestroySession();
}

@ResponseBody
@RequestMapping(value="/send", method=RequestMethod.POST)
public void GetPhoto() {
    
}


}





