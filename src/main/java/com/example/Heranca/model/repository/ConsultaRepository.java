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

    public List<Consulta> consultasPorPaciente(Long id){
        Query query = em.createQuery("from Consulta where paciente.id = :id");
        query.setParameter("id", id);
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    public Consulta getConsulta(Long id){
        Query query = em.createQuery("from Consulta where id = :id");
        query.setParameter("id", id);
        return (Consulta) query.getSingleResult();
    }

    public double totalConsultas (){
        Query query = em.createQuery("select sum(valor) from Consulta");
        return (double) query.getSingleResult();
    }

    public List<Consulta> consultasPorMedico(Long id){
        Query query = em.createQuery("from Consulta where medico.id = :id");
        query.setParameter("id", id);
        System.out.println(query.getResultList());
        return query.getResultList();
    }
}
