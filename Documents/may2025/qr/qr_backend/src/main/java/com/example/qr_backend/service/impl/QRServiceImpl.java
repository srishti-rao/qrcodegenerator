package com.example.qr_backend.service.impl;

import com.example.qr_backend.dto.QRResponse;
import com.example.qr_backend.exception.InvalidBankIdException;
import com.example.qr_backend.service.QRService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class QRServiceImpl implements QRService {

    @Override
    public byte[] generateQR(String bankId){
        if(bankId==null || bankId.trim().isEmpty()){
            throw new InvalidBankIdException("Bank ID cannot be null or empty.");
        }

        try{
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix matrix = writer.encode(bankId, BarcodeFormat.QR_CODE, 250, 250);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, "png", out);
            return out.toByteArray();
        }catch(WriterException | IOException e){
            throw new RuntimeException("Failed to generate QR code.", e);
        }
    }
}
