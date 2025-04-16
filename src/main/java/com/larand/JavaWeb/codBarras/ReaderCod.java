package com.larand.JavaWeb.codBarras;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ReaderCod {
    public static String read() {
        try {
            System.out.println("Entrou no ReaderCod");
            File file = new File("./src/main/java/com/larand/JavaWeb/codBarras/CodBarras.jpg");
            BufferedImage image = ImageIO.read(file);

            // Converte para formato lido pelo ZXing
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Tenta decodificar
            Result result = new MultiFormatReader().decode(bitmap);

            return result.getText();

        } catch (Exception e) {
            System.out.println("Erro ao ler o código de barras: " + e.getMessage());
            return "Erro ao ler o código de barras";
        }
    }
}
