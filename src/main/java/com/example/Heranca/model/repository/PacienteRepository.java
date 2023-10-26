package com.example.Heranca.model.repository;

import com.example.Heranca.model.entity.Paciente;
import com.example.Heranca.model.entity.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteRepository {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Paciente pessoa) {
        em.persist(pessoa);
    }


    public void remover(Long id) {
        em.remove(buscar(id));
    }

    public Pessoa buscar(Long id) {
        return em.find(Pessoa.class, id);
    }

    public void update(Paciente pessoa) {
        em.merge(pessoa);
    }

    public List<Paciente> pacientes() {
        Query query = em.createQuery("FROM Pessoa p WHERE TYPE(p) = Paciente");
        return query.getResultList();
    }
}
