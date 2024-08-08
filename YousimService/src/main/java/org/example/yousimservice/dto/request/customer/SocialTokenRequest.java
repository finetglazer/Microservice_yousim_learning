package org.example.yousimservice.dto.request.customer;

import lombok.Data;
import org.example.yousimservice.dto.request.iRequestData;

@Data
public class SocialTokenRequest implements iRequestData {
    private String accessToken;
    private String provider;
    @Override
    public boolean isValid() {
        return false;
    }
}
