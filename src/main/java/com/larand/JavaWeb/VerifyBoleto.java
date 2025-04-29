package com.larand.JavaWeb;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class VerifyBoleto {

    public static HashMap<String,String> verify(String cod){

        HashMap<String, String> result = new HashMap<>();
        JSONObject bancos = new JSONObject();
        try {
            System.out.println(cod);
            new FileReader("src/main/java/com/larand/JavaWeb/json/bancos.json").close();
            bancos = JsonReader.readJsonFile("src/main/java/com/larand/JavaWeb/json/bancos.json");


            String codBanco = cod.substring(0, 3);
            System.out.println(cod.length());

            System.out.println(codBanco);
            System.out.println(bancos.get(codBanco));

            
            return result;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            HashMap<String, String> errorResponse = new HashMap<>();    
            errorResponse.put("status", "error");
            errorResponse.put("message", "Erro ao processar o código de barras: " + e.getMessage());
            return errorResponse;
        }


        // if (cod.length() < 47) {
        //     HashMap<String, String> errorResponse = new HashMap<>();
        //     errorResponse.put("status", "error");
        //     errorResponse.put("message", "Código de barras incompleto");
        //     return errorResponse;
        // }

    }
}
