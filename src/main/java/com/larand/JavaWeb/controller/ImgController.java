package com.larand.JavaWeb.controller;

import com.larand.JavaWeb.codBarras.ReaderCod;
import com.larand.JavaWeb.VerifyBoleto;
import com.larand.JavaWeb.model.ImageD;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/img")
public class ImgController {
    
    @CrossOrigin(origins = "*")
    @PostMapping
    public HashMap<String, String> uploadImage(@RequestBody ImageD imageD) {
        try {
            if (imageD.getImg() == null || imageD.getImg().isEmpty()) {
                HashMap<String, String> errorResponse = new HashMap<>();
                errorResponse.put("status", "error");
                errorResponse.put("message", "No image data provided");
                return errorResponse;
            }

            // Remover o prefixo 'data:image/jpeg;base64,' se existir
            String base64Image = imageD.getImg().split(",")[1]; 

            String cod = ReaderCod.read(base64Image);

            HashMap<String, String> result = VerifyBoleto.verify(cod);

            return result;
        } catch (IllegalArgumentException e) {
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Invalid base64 image data");
            return errorResponse;
        } catch (Exception e) {
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Error processing image: " + e.getMessage());
            return errorResponse;
        }
    }
}
