package com.lmmf.course.entity;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 瀹炵幇杞挱鍥惧疄浣撶被锛屽苟涓旀坊鍔爏etters鍜実etters鏂规硶锛�
 * 浣滆�咃細宀充紵鐜�
 * 鏃ユ湡锛�2016-11-16
 */
@Entity
@Table(name="shouyelunbotu")
public class LunBoTu {
	 
	 private int id_SYLB;
	 private String pictureURL;
	 private String newsway;
	 	 
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId_SYLB() {
		return id_SYLB;
	}
	public void setId_SYLB(int id_SYLB) {
		this.id_SYLB = id_SYLB;
	}
	public String getpictureURL() {
		return pictureURL;
	}
	public void setpictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public String getnewsway() {
		return newsway;
	}
	public void setnewsway(String newsway) {
		this.newsway =newsway ;
	}

	
}

