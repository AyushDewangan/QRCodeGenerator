package com.example.demo.QRCode;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

@RequestMapping("/v1")
@RestController
public class QRCodeCreation {
	
	@PostMapping("/generateQR")
	public void generateQrCode() {
		
		try {
			//File file = new File("C:\\Users\\ayush.dewangan\\Downloads\\Practice\\QR_Code\\first.jpg");
			String path = "C:\\Users\\ayush.dewangan\\Downloads\\Practice\\QR_Code\\first.jpg";
			String content = "https://ayushdewangan.github.io/Ashish/";
			
			BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 500, 500);
			MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
			System.out.println("QR Code generated.");
		}
		catch(Exception e){
			System.out.println("Exception Occurred : " + e);
		}
		
	}

}
