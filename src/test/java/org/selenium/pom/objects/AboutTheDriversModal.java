package org.selenium.pom.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AboutTheDriversModal {
    AboutTheDriversModal(){

    }

    public AboutTheDriversModal(String  id) throws IOException {
        AboutTheDriversModal[] uniqueNames = JacksonUtils.desearliaze("AboutTheDrivers.json", AboutTheDriversModal[].class);
        for (AboutTheDriversModal uniqueName : uniqueNames) {
            if (uniqueName.getId().equals(id) ){
                this.id = id;

               this.date=uniqueName.getDate();
               this.type=uniqueName.getType();
               this.name=uniqueName.getName();
            }
        }
    }
    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String date;
    String type;


}
