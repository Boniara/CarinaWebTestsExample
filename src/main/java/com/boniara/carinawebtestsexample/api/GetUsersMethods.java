package com.boniara.carinawebtestsexample.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import java.util.Properties;

public class GetUsersMethods extends AbstractApiMethodV2 {

    public GetUsersMethods() {
        super(null, "test_data/_get/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
