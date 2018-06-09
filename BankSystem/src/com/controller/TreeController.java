package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;





import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Resource;
import com.model.TreeDTO;
import com.service.TreeService;



@Controller
public class TreeController {
	
	@Autowired
	private TreeService treeService;
	
	@RequestMapping("getTree")
	@ResponseBody
	public  ResponseEntity<List<TreeDTO>> getTree(HttpServletRequest req){
		String id1=req.getParameter("id");
		Integer id=null;
		if(id1!=null && !id1.equals("") ){
			id=Integer.parseInt(req.getParameter("id"));
		}
		 
		
		List<Resource> rlist= treeService.getChildrenByParentId(id);
		List<TreeDTO> tlist=new ArrayList<TreeDTO>();
		
		for(Resource re:rlist){
			TreeDTO treedto=new TreeDTO();
			treedto.setId(re.getId());
			treedto.setText(re.getName());
			treedto.setIconCls(re.getIcon());
			treedto.setChecked(re.getChecked());
			treedto.setParent_id(re.getParent_id());
			
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("url", re.getUrl());
			treedto.setAttributes(map);
			if(rlist.size()>0){
				treedto.setState("closed");
			}else{
				treedto.setState("open");
			}
			tlist.add(treedto);
			
		}
		return new ResponseEntity<List<TreeDTO>>(tlist,HttpStatus.OK);
		
		
	}
	
	
	

}
