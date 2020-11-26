package com.jhon.latihanspring.utils;

import com.jhon.latihanspring.DTO.ResponseDTO;

public class ResponseUtils {
    public static void setResponse(ResponseDTO response, ResponseEnum responseEnum) {
        response.setStatus(responseEnum.getStatus());
        response.setStatusCode(responseEnum.getCode());
    }
}
