package org.lycoding.pojo;

import lombok.Data;

@Data
public class emp {
    private String name;
    private int age;

    public emp(String name,int age){
        this.name=name;
        this.age=age;
    }

}
