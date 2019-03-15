package com.aibaoxian.auth.exception;

import com.aibaoxian.auth.enums.ErrorCodeEnum;
import com.aibaoxian.auth.utils.R;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public R all(Exception ex) {
        ex.printStackTrace();
        R r = R.error(ErrorCodeEnum.RC_500, ex.getMessage());
        return  r;
    }
}
