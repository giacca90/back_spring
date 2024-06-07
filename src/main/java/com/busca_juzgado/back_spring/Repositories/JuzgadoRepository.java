package com.busca_juzgado.back_spring.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busca_juzgado.back_spring.Models.Juzgado;

@Repository
public interface JuzgadoRepository extends JpaRepository<Juzgado, Long> {
    // List<Juzgado> findBy(String pueblo);

    List<Juzgado> findByNombreContainsIgnoreCase(String pueblo);

    List<Juzgado> findByPuebloIgnoreCase(String pueblo);

    List<Juzgado> findByProvinciaIgnoreCase(String provincia);

    List<Juzgado> findByComunidadIgnoreCase(String pueblo);

    // List<Juzgado> findByCustomJuzgado(Juzgado juzgado);

}
