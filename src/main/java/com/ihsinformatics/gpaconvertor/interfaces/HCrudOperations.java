package com.ihsinformatics.gpaconvertor.interfaces;

import java.util.List;

public interface HCrudOperations<T> {

	List<T> getAll();

	T getSingle(int id);

	boolean delete(int id);

	boolean update(T data);

	boolean save(T data);

}
