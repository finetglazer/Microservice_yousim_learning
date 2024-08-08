package org.example.yousimservice.dto.response.Customer;

import lombok.Data;
import org.example.yousimservice.model.Customer;

@Data
public class CustomerResponse extends Customer {
    String token;
    String session;
    String hashImgFont;
    private String addr;//địa chỉ chung
}
