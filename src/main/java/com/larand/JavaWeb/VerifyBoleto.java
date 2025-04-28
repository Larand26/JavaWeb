package com.larand.JavaWeb;

import java.util.HashMap;

import com.larand.JavaWeb.json.bancos;

public class VerifyBoleto {
    public static HashMap<String,String> verify(String cod){

        HashMap<String, String> result = new HashMap<>();

        if (cod.length() < 47) {
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Código de barras incompleto");
            return errorResponse;
        }

        String codBanco = cod.substring(0, 3);
        System.out.println(cod.length());
        
        return result;
    }
}
