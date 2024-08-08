package org.example.yousimservice.dto.request.customer;

import lombok.Data;
import org.example.yousimservice.dto.request.iRequestData;

@Data
public class SocialAccountInfo implements iRequestData {
    private String id;
    private String email;
    private String name;
    private String picture;
    private String provider;
    //    private String providerId;
    @Override
    public boolean isValid() {
        return false;
    }
}
