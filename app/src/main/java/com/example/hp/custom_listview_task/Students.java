package com.example.hp.custom_listview_task;

/**
 * Created by HP on 9/29/2016.
 */
public class Students {

    String name;
    String designation;
    String qualification;
    String experties;
    int contact;
    int id;


    public Students(int id,String name, String designation, String qualification, String experties, int contact) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.qualification = qualification;
        this.experties = experties;
        this.contact = contact;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExperties() {
        return experties;
    }

    public void setExperties(String experties) {
        this.experties = experties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
