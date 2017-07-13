package com.sai.quotes.quotes.pictures;

import java.io.Serializable;

/**
 * Created by PrasannakumarA on 5/19/2017.
 */

public class PicturesPOJO implements Serializable {


    private String url;
    private String heading;
    private  String body;

    public PicturesPOJO(String heading, String body,String url) {
        this.heading = heading;
        this.body = body;
        this.url=url;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
