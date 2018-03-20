package cn.com.fourwind.propertyManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.com.fourwind.propertyManager.entity.FuncInfo;

@Repository
public interface IFuncInfoRepository extends JpaRepository<FuncInfo	, Long>{
	public FuncInfo findByFuncId(String funcId);
}
