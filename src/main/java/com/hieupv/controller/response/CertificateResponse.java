package com.hieupv.controller.response;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class CertificateResponse {
    private String nameSubject;
    private String nameStudent;
    private String grade;
    private Timestamp dateOfDone;
}
