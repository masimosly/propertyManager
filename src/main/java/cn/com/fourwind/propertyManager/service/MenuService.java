package cn.com.fourwind.propertyManager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.fourwind.propertyManager.entity.BaseMenu;
import cn.com.fourwind.propertyManager.entity.Menu;
import cn.com.fourwind.propertyManager.entity.MenuF;
import cn.com.fourwind.propertyManager.repository.IMenuRepository;

@Service
public class MenuService {

	@Autowired
	private IMenuRepository menuRepository;
	
	public List<MenuF> generatorMenu(){
		
		
		List<Menu> list  = menuRepository.getAllMenuData();
		List<MenuF> listf=new ArrayList<>();
		for (Menu menu : list) {
			MenuF menuF =new MenuF();
			menuF.setId(menu.getLabel());
			menuF.setIcon(menu.getIcon());
			menuF.setText(menu.getText());
			menuF.setPid(menu.getPid());
			menuF.setMenuId(menu.getId());
			listf.add(menuF);
		}
		
		return formatTree(listf);
		
	}
	
	public void delMenu(Long id) {
		
		menuRepository.delete(id);
		
	}
	
	
	public List<BaseMenu> generatorMenub(){
		
		List<Menu> list  = menuRepository.getAllMenuData();
		List<BaseMenu> listf=new ArrayList<>();
		for (Menu menu : list) {
			BaseMenu mm =new BaseMenu();
			mm.setId(menu.getId());
			mm.setLabel(menu.getText());
			mm.setPid(menu.getPid());
			mm.setLabelEn(menu.getLabel());
			listf.add(mm);
		}
		
		return formatTreeB(listf);
		
	}
	
	private List<BaseMenu> formatTreeB(List<BaseMenu> list) {
		BaseMenu root=new BaseMenu();  
		BaseMenu node=new BaseMenu();  
        List<BaseMenu> treelist=new ArrayList<>();
        List<BaseMenu> parentNodes=new ArrayList<>(); // 存放所有父节点  
          
         if(list!=null && list.size()>0){  
                 root=list.get(0); //第一个一定是根节点 0  
                   
               for(int i=1; i<list.size(); i++){  
                   node=list.get(i);  
                   if(node.getPid()==root.getId()){ //从跟节点开始遍历是不是子节点  
                	   System.out.println("相等pid="+node.getPid()+"id="+root.getId());
                       parentNodes.add(node);  
                       root.getChildren().add(node);  
                       
                       
                     
                   }else{ //获取root子节点的孩子节点  
                	   System.out.println("不相等"+"pid="+node.getPid()+"id="+root.getId());
                        getChildrenNodesB(parentNodes, node);   
       
                        parentNodes.add(node);  
                   }  
               }    
         }  
         treelist.add(root);  
         System.out.println(treelist);
         return treelist;  
	}


	private void getChildrenNodesB(List<BaseMenu> parentNodes, BaseMenu node) {
		// TODO Auto-generated method stub
		 for(int i=parentNodes.size()-1; i>=0; i--){  
			 BaseMenu pnode=parentNodes.get(i);  
	             if(pnode.getId()==node.getPid()){  
	                 pnode.getChildren().add(node);  
	                 return;  
	             }  
	 
	              
	        }  
		
	}


	public int save(Menu menu) {
		
		try {
			menuRepository.save(menu);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}
	
	private  List<MenuF> formatTree(List<MenuF> list ){  
		MenuF root=new MenuF();  
		MenuF node=new MenuF();  
        List<MenuF> treelist=new ArrayList<>();
        List<MenuF> parentNodes=new ArrayList<>(); // 存放所有父节点  
          
         if(list!=null && list.size()>0){  
                 root=list.get(0); //第一个一定是根节点 0  
                   
               for(int i=1; i<list.size(); i++){  
                   node=list.get(i);  
                   if(node.getPid()==root.getMenuId()){ //从跟节点开始遍历是不是子节点  
                	   System.out.println("相等pid="+node.getPid()+"id="+root.getId());
                       parentNodes.add(node);  
                       root.getChildren().add(node);  
                       
                       
                     
                   }else{ //获取root子节点的孩子节点  
                	   System.out.println("不相等"+"pid="+node.getPid()+"id="+root.getId());
                        getChildrenNodes(parentNodes, node);   
       
                        parentNodes.add(node);  
                   }  
               }    
         }  
         treelist.add(root);  
         System.out.println(treelist);
         return treelist;  
           
         } 
    
    
    private  void getChildrenNodes(List<MenuF> parentNodes , MenuF node){  
        for(int i=parentNodes.size()-1; i>=0; i--){  
        	MenuF pnode=parentNodes.get(i);  
             if(pnode.getMenuId()==node.getPid()){  
                 pnode.getChildren().add(node);  
                 return;  
             }  
 
              
        }  
   }
}
