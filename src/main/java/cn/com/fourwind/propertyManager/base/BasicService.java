package cn.com.fourwind.propertyManager.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class BasicService<T> {
	
	@Autowired
	private IBasicRepository<T> basicRepository;
	
	public T save(T entity) throws Exception {
		return basicRepository.save(entity);
	}
	public Page<T> findAll(Pageable pageable){
		return (Page<T>) basicRepository.findAll(pageable);
	}
	public T delete(Long id) throws Exception {
//		T t = findById(id);
		 basicRepository.delete(id);
		 return null;
	}
	public T findById(String id) {
		return basicRepository.findById(id);
	}
	
//	public void deleteAll() {
//		basicRepository.deleteAll();
//	}
//	public T findOne(Long id) {
//	return basicRepository.findOne(id);
//}
//public boolean exists(Long id) {
//	return basicRepository.exists(id);
//}
//public long count() {
//	return basicRepository.count();
//}
	
	
	 
}
