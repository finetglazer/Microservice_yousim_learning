package org.example.yousimservice.dto.request.api;

import lombok.Data;
import org.example.yousimservice.dto.request.iRequestData;
import org.example.yousimservice.model.Api;

@Data
public class ApiRequest extends Api implements iRequestData {
    private int page;
    private int pageSize;
    @Override
    public boolean isValid() {
        return false;
    }
}
