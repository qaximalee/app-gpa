package com.ihsinformatics.gpaconvertor.interfaces;

import java.util.List;

public interface ICrudOperations<T> {

    boolean save(T data);

    boolean delete(int id);

    boolean update(T data);

    List<T> getAll();

    T getSingle(int id);
}
