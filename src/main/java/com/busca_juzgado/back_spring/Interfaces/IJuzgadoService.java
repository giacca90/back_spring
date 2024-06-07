package com.busca_juzgado.back_spring.Interfaces;

import java.util.List;

import com.busca_juzgado.back_spring.Models.Juzgado;

public interface IJuzgadoService {
    public List<Juzgado> getAllJuzgados();

    public List<Juzgado> getJuzgadoForPueblo(String pueblo);

    public List<Juzgado> getJuzgadoForProvincia(String pueblo);

    public List<Juzgado> getJuzgadoForComunidad(String pueblo);

    public List<Juzgado> getJuzgadoForNombre(String pueblo);

    public List<Juzgado> getCustomJuzgado(Juzgado juzgado);

}
