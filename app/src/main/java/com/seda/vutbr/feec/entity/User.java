package com.seda.vutbr.feec.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Seda on 10/1/2016.
 */
@DatabaseTable(tableName = "user")
public class User {
    @DatabaseField(generatedId=true)
    private Long id;
    @DatabaseField(unique = true)
    private String id_email;
    @DatabaseField(canBeNull = true)
    private String name;

    public User(){}

    public User(String id_email){
        this.id_email = id_email;
    }
    public User(String id_email, String name){
        this.id_email=id_email;
        this.name = name;
    }

    public void setIdEmail(String id_email){
        this.id_email = id_email;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getIdEmail(){
        return this.id_email;
    }

    public String getName(){
        return this.name;
    }

    public Long getId(){
        return this.id;
    }


}
