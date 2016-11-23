package com.lmmf.course.lbt.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmmf.course.entity.LunBoTu;
import com.lmmf.course.lbt.dao.LbtDaoImpl;
import com.lmmf.framework.Page;
/**
 * 閰嶇疆杞挱鍥炬ā鍧椾笟鍔￠�昏緫灞傦紝璋冪敤LbtDaoImpl绫婚噷鐨勬柟娉曪紱
 * 浣滆�咃細宀充紵鐜�
 * 鏃ユ湡锛�2016-11-16
 */

@Service
@Transactional(readOnly=false)
public class LunBoTuServiceImpl {
	
	
	@Resource
	private LbtDaoImpl lunbotuDaoImpl;
	
	public void addLunBoTu( LunBoTu lunbotu){
		this.lunbotuDaoImpl.saveLunBoTu(lunbotu);
	}

	@Transactional(readOnly=true)
	public Page<LunBoTu> listLunBoTu(int pageNum,int pageSize,Object[] params){
		return this.lunbotuDaoImpl.findLunBoTu(pageNum, pageSize, params);
	}
	
	@Transactional(readOnly=true)
	public LunBoTu getLunBoTu(int id_SYLB){
		return this.lunbotuDaoImpl.getLunBoTu(id_SYLB);
	}
	
	public void editLunBoTu(LunBoTu lunbotu){
		LunBoTu lbt=this.lunbotuDaoImpl.getLunBoTu(lunbotu.getId_SYLB());
		lbt.setpictureURL(lunbotu.getpictureURL());
		lbt.setnewsway(lunbotu.getnewsway());
		this.lunbotuDaoImpl.updateLunBoTu(lbt);
	}
	
	public void dropLunBoTu(int id_SYLB){
		this.lunbotuDaoImpl.deleteLunBoTu(id_SYLB);
	}

}
