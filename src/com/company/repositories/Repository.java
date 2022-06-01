package com.company.repositories;

import com.company.domain.Cliente;
import com.company.domain.EntidadeBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Classe responsável por realizar as operações de CRUD para entidade Cliente.
 *
 * @author Diego Barros
 **/

public abstract class Repository<T extends EntidadeBase> {

    //simular uma base de dados
    private List<T> db = new ArrayList<>();

    /**
     * Método responsável por adicionar um objeto a base de dados.
     *
     * @param obj
     * @return boolean
     */

    //save salve/update
    public boolean save(T obj) {
        return db.add(obj);
    }

    //find
    public T findById(Integer id) {
        for (T obj: db) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    //findAll
    public List<T> findAll(){
        return db.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    //Delete
    public boolean delete(T obj) {
        return db.remove(obj);
    }
}
