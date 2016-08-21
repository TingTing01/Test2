package com.tourcan.att.model;

import java.util.List;

public class AttService {

	private AttDAO_interface dao;
	public AttService(){
		dao = new AttDAO();
	}
	
    public Integer getId(String att_name){
    	return dao.getId(att_name);
    }

	
	public AttVO getOne(Integer att_id){
		return dao.findById(att_id);
	}
	public List<AttVO> getAllByName(String att_name){
		return dao.findByName(att_name);
	}
	
	public List<AttVO> getAll(){
		return dao.getAll();
		
	}
	
}
