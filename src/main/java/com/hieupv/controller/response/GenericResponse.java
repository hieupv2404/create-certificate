package com.hieupv.controller.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GenericResponse {
    private int count;
    private List listResponse = new ArrayList();
}
