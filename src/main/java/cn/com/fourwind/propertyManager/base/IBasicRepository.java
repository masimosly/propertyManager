package cn.com.fourwind.propertyManager.base;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@ConditionalOnExpression("false")
public interface IBasicRepository<T> {
	 T save(T entity) throws Exception;
	 Page<T> findAll(Pageable pageable);
	 void delete(Long id)  throws Exception;
	 T findById(String id);
}
