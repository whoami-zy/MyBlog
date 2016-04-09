package com.whomai.dao;

import java.util.List;

import com.whoami.po.photos;

public interface photosDao {
		public boolean addImage(photos photo);
		public boolean deleteImage(int id);
		public List<photos> viewImage();
}
