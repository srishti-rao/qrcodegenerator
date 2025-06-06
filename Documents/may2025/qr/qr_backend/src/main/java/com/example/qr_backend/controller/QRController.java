package com.example.qr_backend.controller;

import com.example.qr_backend.dto.QRRequest;
import com.example.qr_backend.dto.QRResponse;
import com.example.qr_backend.service.QRService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/qrcode")
@Tag(name="QR Management")
public class QRController {
    private final QRService qrService;

    @Operation(summary="generateqr", description="generates qr")
    @PostMapping(value="/generate", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQR(@RequestBody QRRequest request) {
        byte[] qrImage = qrService.generateQR(request.getBankId());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(qrImage);
    }
}
