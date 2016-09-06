package com.boniara.carinawebtestsexample.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;

import static com.boniara.carinawebtestsexample.utils.Constants.API_URL;

public class PostUsersMethods extends AbstractApiMethodV2 {

    public PostUsersMethods(String rq, String rs, String prop) {
        super(rq, rs, prop);
        replaceUrlPlaceholder("base_url", API_URL);
    }
}
