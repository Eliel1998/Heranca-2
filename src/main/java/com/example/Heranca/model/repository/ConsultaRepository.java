package com.example.Heranca.model.repository;

import com.example.Heranca.model.entity.Consulta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Consulta> consultas(){
        Query query = em.createQuery("from Consulta");
        return query.getResultList();
    }

    public void salvar(Consulta consulta) {
        em.persist(consulta);
    }

    public void atualizar(Consulta consulta) {
        em.merge(consulta);
    }

    public void remover(Long id) {
        em.remove(em.getReference(Consulta.class, id));
    }



    public Consulta getConsulta(Long id){
        Query query = em.createQuery("from Consulta where id = :id");
        query.setParameter("id", id);
        return (Consulta) query.getSingleResult();
    }

}
