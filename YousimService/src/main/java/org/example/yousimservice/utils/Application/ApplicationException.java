package org.example.yousimservice.utils.Application;

import lombok.Data;
import org.example.yousimservice.utils.MessageUtils;

@Data
public class ApplicationException extends Exception {

    private String code;
    private String message;
    private String language;
    private String attack;
    private boolean hasAttack = false;

    public ApplicationException(String code) {
        this.code = code;
        this.message= MessageUtils.getMessage(code);
    }
    public ApplicationException(String code, String language) {
        this.code = code;
        this.message = MessageUtils.getMessage(code, language);
    }

    public ApplicationException(String code, String attack, boolean hasAttack) {
        this.code = code;
        this.attack = attack;
        this.hasAttack = hasAttack;
    }

//    public ApplicationException(String code, String language, Object... arg) {
//        this.code = code;
//        this.message = MessageUtils.getMessage(code, language, arg);
//    }

    public ApplicationException(String code, Object... arg) {
        this.code = code;
        this.message = MessageUtils.getMessage(code, arg);
    }

    public ApplicationException(String codeBss, String code, String message, String language) {
        this.code = codeBss;
        this.message = message;
    }
}