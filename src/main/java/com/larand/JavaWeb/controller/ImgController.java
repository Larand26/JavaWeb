package com.larand.JavaWeb.controller;

import com.larand.JavaWeb.codBarras.ReaderCod;
import com.larand.JavaWeb.model.ImageD;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
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

            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // Caminho para salvar a imagem
            Path path = Paths.get("./src/main/java/com/larand/JavaWeb/codBarras/CodBarras.jpg");
            Files.write(path, imageBytes);
            String cod = ReaderCod.read();

            HashMap<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Image uploaded successfully");
            response.put("cod", cod);

            return response;
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
