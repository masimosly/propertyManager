package cn.com.fourwind.propertyManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.fourwind.propertyManager.entity.FuncInfo;
import cn.com.fourwind.propertyManager.repository.IFuncInfoRepository;

@Service
public class FuncInfoService {
	
	@Autowired
	private IFuncInfoRepository funcInfoRepository;

	public FuncInfo savefuncInfo(FuncInfo info) {
		
		
		return funcInfoRepository.save(info);
	}
	
	public FuncInfo getFuncInfo(String funcId) {
		
		
		return funcInfoRepository.findByFuncId(funcId);
		
	}
	
	public void deleteFuncInfo(String funcId) {
		
		FuncInfo one =funcInfoRepository.findByFuncId(funcId);
		if(one!=null) {
			
			funcInfoRepository.delete(one.getId());
			
		}
		
	}
	
	
	public List<FuncInfo> findAllFuncInfo(){
		
		return funcInfoRepository.findAll();
		
	}
}
