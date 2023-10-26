package com.example.Heranca.model.repository;

import com.example.Heranca.model.entity.Medico;
import com.example.Heranca.model.entity.Paciente;
import com.example.Heranca.model.entity.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicoRepository {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Medico pessoa) {
        em.persist(pessoa);
    }

    public void atualizar(Medico pessoa) {
        em.merge(pessoa);
    }

    public void remover(Long id) {
        em.remove(buscar(id));
    }

    public Medico buscar(Long id) {
        return em.find(Medico.class, id);
    }

    public List<Medico> buscarPorMedicos() {
        Query query = em.createQuery("FROM Pessoa p WHERE TYPE(p) = Medico");
        return query.getResultList();
    }
}
