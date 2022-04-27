package com.easyquiz.EasyQuizServer.service;

import java.util.Collection;

/**
 * Created by sgva1 on 4/5/2020.
 */
public interface BaseMethods<T> {
    boolean save(T t);

    T getById(Long id);

    Collection<T> getAll();

    T edit(T t);

    void delete(T t);
}
