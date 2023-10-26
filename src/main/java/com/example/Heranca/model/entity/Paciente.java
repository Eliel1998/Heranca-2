package com.example.Heranca.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("paciente")
public class Paciente extends Pessoa implements Serializable {
    private String telefone;

    public Paciente(String telefone) {
        this.telefone = telefone;
    }

    public Paciente() {
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
