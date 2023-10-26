package com.example.Heranca.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("medico")
public class Medico extends Pessoa implements Serializable {
    private String crm;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Medico(String crm) {
        this.crm = crm;
    }

    public Medico() {
    }
}
