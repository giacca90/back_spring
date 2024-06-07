package com.busca_juzgado.back_spring.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busca_juzgado.back_spring.Interfaces.IJuzgadoService;
import com.busca_juzgado.back_spring.Models.Juzgado;
import com.busca_juzgado.back_spring.Repositories.JuzgadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class JuzgadoService implements IJuzgadoService {

    @Autowired
    private JuzgadoRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Juzgado> getCustomJuzgado(Juzgado juzgado) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Juzgado> cq = cb.createQuery(Juzgado.class);
        Root<Juzgado> juzgadoRoot = cq.from(Juzgado.class);

        List<Predicate> predicates = new ArrayList<>();

        if (juzgado.getNombre() != null) {
            predicates.add(cb.like(cb.lower(juzgadoRoot.get("nombre")),
                    "%" + juzgado.getNombre().toLowerCase() + "%"));
        }

        if (juzgado.getPueblo() != null) {
            predicates.add(cb.like(cb.lower(juzgadoRoot.get("pueblo")),
                    "%" + juzgado.getPueblo().toLowerCase() + "%"));
        }

        if (juzgado.getProvincia() != null) {
            predicates.add(cb.like(cb.lower(juzgadoRoot.get("provincia")),
                    "%" + juzgado.getProvincia().toLowerCase() + "%"));
        }

        if (juzgado.getComunidad() != null) {
            predicates.add(cb.like(cb.lower(juzgadoRoot.get("comunidad")),
                    "%" + juzgado.getComunidad().toLowerCase() + "%"));
        }

        Predicate finalPredicate = cb.and(predicates.toArray(new Predicate[0]));
        cq.where(finalPredicate);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Juzgado> getAllJuzgados() {
        List<Juzgado> result = this.repo.findAll();
        return result;
    }

    @Override
    public List<Juzgado> getJuzgadoForNombre(String nombre) {
        return this.repo.findByNombreContainsIgnoreCase(nombre);
    }

    @Override
    public List<Juzgado> getJuzgadoForPueblo(String pueblo) {
        return this.repo.findByPuebloIgnoreCase(pueblo);
    }

    @Override
    public List<Juzgado> getJuzgadoForProvincia(String provincia) {
        return this.repo.findByProvinciaIgnoreCase(provincia);
    }

    @Override
    public List<Juzgado> getJuzgadoForComunidad(String comunidad) {
        return this.repo.findByComunidadIgnoreCase(comunidad);
    }
}
