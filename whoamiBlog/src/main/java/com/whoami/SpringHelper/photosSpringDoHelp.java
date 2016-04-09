package com.whoami.SpringHelper;

import java.util.List;

import com.whoami.po.photos;
import com.whomai.dao.photosDao;

public class photosSpringDoHelp {
	private photos photo;
	private photosDao photoDo;
	public photos getPhoto() {
		return photo;
	}
	public void setPhoto(photos photo) {
		this.photo = photo;
	}
	public photosDao getPhotoDo() {
		return photoDo;
	}
	public void setPhotoDo(photosDao photoDo) {
		this.photoDo = photoDo;
	}
	
	public boolean add(){
		if(photoDo.addImage(photo)){
			return true;
		}
		return false;
	}
	public boolean delete(int id){
		if(photoDo.deleteImage(id)){
			return true;
		}
		return false;
	}
	public List<photos> view(){
		return photoDo.viewImage();
	}
}
