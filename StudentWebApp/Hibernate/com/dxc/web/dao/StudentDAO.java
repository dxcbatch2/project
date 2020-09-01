package com.dxc.web.dao;

import java.util.List;



public interface StudentDAO <E> {
	E save(E e) throws Exception;
	E edit(E e) throws Exception;
	int delete(int id) throws Exception;
	E find(int id) throws Exception;
	List<E> findAll() throws Exception;

}
