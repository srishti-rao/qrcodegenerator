package com.example.qr_backend.service;

import com.example.qr_backend.dto.QRResponse;

public interface QRService {
    byte[] generateQR(String bankId);
}
