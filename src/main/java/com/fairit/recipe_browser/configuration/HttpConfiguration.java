package com.fairit.recipe_browser.configuration;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HttpConfiguration {

    private HttpHeaders httpHeaders;

    public HttpConfiguration(final HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public HttpEntity getHttpEntity() {
        httpHeaders.set("?apiKey=", "17cc8ec769ef40cea70ed0456d3d851b");
        return new HttpEntity(httpHeaders);
    }
}
