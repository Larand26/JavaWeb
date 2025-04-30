package com.larand.JavaWeb;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class VerifyBoleto {

    public static HashMap<String,String> verify(String cod){

        HashMap<String, String> result = new HashMap<>();
        JSONObject bancos = new JSONObject();
        try {
            new FileReader("src/main/java/com/larand/JavaWeb/json/bancos.json").close();
            bancos = JsonReader.readJsonFile("src/main/java/com/larand/JavaWeb/json/bancos.json");

            String codBanco = cod.substring(0, 3);
            String codMoeda = cod.substring(3, 4);

            JSONObject banco = (JSONObject) bancos.get(codBanco);
            String nomeBanco = (String) banco.get("nome");
            String logoBanco = (String) banco.get("logo");
            String moeda = codMoeda.equals("9") ? "Real" : "Outro";

            result.put("nomeBanco", nomeBanco);
            result.put("logoBanco", logoBanco);
            result.put("moeda", moeda);
            result.put("status", "success");
            
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
