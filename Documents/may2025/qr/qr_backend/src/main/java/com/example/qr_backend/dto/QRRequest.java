package com.example.qr_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QRRequest {
    @Schema(description = "bankid", requiredMode =Schema.RequiredMode.REQUIRED, example = "12345")
    private String bankId;
}
