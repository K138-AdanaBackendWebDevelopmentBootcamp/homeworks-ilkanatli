package dev.patika.week3;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class StringResponse {
    private String name;
    private int year;

    public StringResponse(String name) {
        this.name = name;
    }

    public StringResponse() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
