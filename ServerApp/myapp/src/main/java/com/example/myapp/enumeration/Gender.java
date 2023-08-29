package com.example.myapp.enumeration;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Gender {
    male("male"),
    female("female"),
    other("other");

    private final String gender; //string that represents the status

    Gender(String gender){
    this.gender= gender;
    }


}
