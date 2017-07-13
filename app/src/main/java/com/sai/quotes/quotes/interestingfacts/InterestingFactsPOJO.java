package com.sai.quotes.quotes.interestingfacts;

import java.io.Serializable;

/**
 * Created by PrasannakumarA on 5/19/2017.
 */

public class InterestingFactsPOJO implements Serializable {

    private String heading;
    private  String body;

    public InterestingFactsPOJO(String heading, String body) {
        this.heading = heading;
        this.body = body;
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



}
