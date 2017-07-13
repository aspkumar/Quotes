package com.sai.quotes.quotes.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture {

@SerializedName("description")
@Expose
private String description;
@SerializedName("image")
@Expose
private String image;

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

}
