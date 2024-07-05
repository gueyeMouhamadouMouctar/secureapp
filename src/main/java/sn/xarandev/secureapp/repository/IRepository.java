package sn.xarandev.secureapp.repository;

import java.util.List;

public interface IRepository<T> {
	
	public boolean save(T t) ;
	public boolean update(T t) ;
	public List<T> list(T t) ;
	public boolean delete(int id, T t);
	public T get(int id, T t) ;

}
