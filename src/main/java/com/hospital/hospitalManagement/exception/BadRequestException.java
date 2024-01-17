package com.hospital.hospitalManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BadRequestHandler  extends  RuntimeException{
    private  final  String  status;
    private  final  String message;
}
