package com.lmmf.course.lbt.dao;



import org.springframework.stereotype.Repository;


import com.lmmf.course.entity.LunBoTu;
import com.lmmf.framework.BaseDao;
import com.lmmf.framework.Page;
/**
 * 配置轮播图持久化层，实现类里的方法；
 * 作者：岳伟玺
 * 日期：2016-11-16
 */

@Repository
public class LbtDaoImpl extends BaseDao<LunBoTu, Integer> {
	
	public void saveLunBoTu(LunBoTu lunbotu){
		try {
			this.save(lunbotu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Page<LunBoTu> findLunBoTu(int pageNum, int pageSize,Object[] params){
		String hql;
		if(params!=null && params.length>0){
			hql="from LunBoTu lunbotu where shouyelunbotu.pictureURL_href like ?";
			params[0]="%"+params[0]+"%";
			
		}else{
			hql="from LunBoTu";
		}
		try {
			Page<LunBoTu> page=new Page<LunBoTu>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page=this.findByPage(pageNum, pageSize, hql, params);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public LunBoTu getLunBoTu(int id_SYLB){
		try {
			LunBoTu lunbotu=this.get(id_SYLB);
			return lunbotu;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void updateLunBoTu(LunBoTu lunbotu){
		try {
			this.update(lunbotu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteLunBoTu(int id_SYLB){
		try {
			this.delete(id_SYLB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
