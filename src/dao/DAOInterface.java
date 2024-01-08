package dao;

import java.util.List;

public interface DAOInterface<T, K> {
	public boolean insert(T t);
	public boolean update(T t, K id);
	public boolean delete(K id);
	public List<T> selectAll();
	public T selectById(K id);
	public List<T> selectByName(K search);
}
