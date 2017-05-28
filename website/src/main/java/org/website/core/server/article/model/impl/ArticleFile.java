package org.website.core.server.article.model.impl;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author xuejingque 文章文件类
 *
 */
@Entity
@Table(name="gm_website_articlefile")
public class ArticleFile {
	/*文章文件id*/
	private Integer id;
	/*排序id，用于附件进行排序*/
	private Integer orderId;
	/*文章文本名称*/
	private String name;
	/*文章文本下载地址*/
	private String fileUrl;
	/*文章文件上传时间*/
	private Date uploadDate;
	/*文章文件-文章 多对一*/
	private Article articles;
	
	private String fileType;
	
	private String fileSize;
	
	private Integer isImage;
	
	private String remark;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="order_id")
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Column(length=50)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=250 , name="file_url")
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	@Column(nullable=false,columnDefinition="datetime")
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleFile other = (ArticleFile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@ManyToOne(cascade = CascadeType.REFRESH) @JoinColumn(name = "article_id")
	public Article getArticles() {
		return articles;
	}
	public void setArticles(Article articles) {
		this.articles = articles;
	}
	
	@Column(name = "file_type")
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	@Column(name = "file_size")
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	@Column(name = "is_image")
	public Integer getIsImage() {
		return isImage;
	}
	public void setIsImage(Integer isImage) {
		this.isImage = isImage;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
