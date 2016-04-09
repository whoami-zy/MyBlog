package com.whoami.struts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;
import com.whoami.SpringHelper.photosSpringDoHelp;
import com.whoami.po.photos;

public class photoAction extends supperAction implements ModelDriven<photos>{

	private static final long serialVersionUID = 1L;
	/**
	 * 实现spring的xml导入。实现spring的控制注入（相当于new）
	 */
	
	ApplicationContext context = new ClassPathXmlApplicationContext(new String [] {"photosDo.xml"});
	photosSpringDoHelp photosSpring = (photosSpringDoHelp) context.getBean("photosDoHelp");
	photos photo = new photos();
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String dataUrl;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public String addImage() throws Exception{
		//String imgpath="photos/";
		InputStream is = new FileInputStream(file);
		//String path = "C:\\Users\\ZYong\\workspace\\whoamiBlog\\target\\m2e-wtp\\web-resources\\";
		String path = "/home/www/photos/";
		//dataUrl=imgpath+this.getFileFileName();
		File destFile = new File(path, this.getFileFileName());
		OutputStream os = new FileOutputStream(destFile);
		 byte[] buffer = new byte[1024];
		 int length = 0;
		 while ((length = is.read(buffer)) > 0) {
			            os.write(buffer, 0, length);
			   }
		 is.close();
	    os.close();
	    /**
	    photo.setP_name(this.getFileFileName());
	    String time =new java.text.SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(new Date()).toString();
	    photo.setP_time(time);
	    photo.setU_id(1);
	    photo.setP_path(path+dataUrl);
	    photosSpring.setPhoto(photo);
	    */
	    if(photosSpring.add()){
	    	List<photos> list = photosSpring.view();
	    	request.setAttribute("listAllImages", list);
	    	return "addPhotoSuccess";
	    }
	    return "addPhotoFalse";
	}
	public String view(){
		List<photos> list = photosSpring.view();
		request.setAttribute("listAllImages", list);
    	return "addPhotoSuccess";
	}
	public photos getModel() {
	
		return photo;
	}

}
