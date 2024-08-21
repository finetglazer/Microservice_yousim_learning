package org.example.yousimservice.controller;

import org.example.yousimservice.dto.response.BaseResponseData;
import org.example.yousimservice.utils.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public abstract class BaseController {
    // thành công có respone trả về
    protected <T> ResponseEntity success(T respone) {
        BaseResponseData baseResponseData= new BaseResponseData();
        baseResponseData.setCode("success");
        baseResponseData.setMessage(MessageUtils.getMessage("success"));
        baseResponseData.setWsResponse(respone);
        return new ResponseEntity(baseResponseData, HttpStatus.OK);
    }
    protected ResponseEntity error(String code, String message) {
        BaseResponseData baseResponseData= new BaseResponseData();
        baseResponseData.setCode(code);
        baseResponseData.setMessage(message);
        return new ResponseEntity(baseResponseData, HttpStatus.OK);
    }

    // thành công không có respone trả về
    protected ResponseEntity success() {
        BaseResponseData baseResponseData= new BaseResponseData();
        baseResponseData.setCode("success");
        baseResponseData.setMessage(MessageUtils.getMessage("success"));
        return new ResponseEntity(baseResponseData, HttpStatus.OK);
    }
}
