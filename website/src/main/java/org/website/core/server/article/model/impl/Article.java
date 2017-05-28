package org.website.core.server.article.model.impl;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * 
 * @author garmin 文章类
 *
 */
@Entity
@Table(name="gm_website_article")
public class Article {

    /* 文章id */
	private Integer id;
	/* 文章标题 */
	private String title;
	/* 文章发布日期*/
	private Date date;
	/* 文章发布内容*/
	private String content;
	/* 文章是否可见*/
	private Integer visit;
	/* 文章发布人*/
	private String username;
	/* 文章访问量*/
	private Integer visitTotal;
	/*文章关键字*/
	private String keyword;
	/*文章-栏目 多对一关系 */
	private Shed sheds;
    /*文章-文章文件 一对多关系*/
	private Set<ArticleFile> articleFile = new TreeSet<ArticleFile>();
	/*	假字段*/
	private String isFile;//是否有附件； 
	/*文章排序id*/
	private Integer orderId;
	
	/*文章置顶标识*/
	private Integer isTop; //置顶为1,不置顶为0；
	
	/*置顶s时间*/
	private Date topTime;
	
	/*摘要*/
	private String digest;
	
	private Integer visitNum;//访问人数

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length=200,nullable=false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(columnDefinition="text")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(length=10)
	public Integer getVisit() {
		return visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}

	@Column(length=20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length=10,name="visit_total")
	public Integer getVisitTotal() {
		return visitTotal;
	}

	public void setVisitTotal(Integer visitTotal) {
		this.visitTotal = visitTotal;
	}

	@Column(length=50)
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="shed_id")
	public Shed getSheds() {
		return sheds;
	}

	public void setSheds(Shed sheds) {
		this.sheds = sheds;
	}

	@OneToMany(mappedBy = "articles")
	public Set<ArticleFile> getArticleFile() {
		return articleFile;
	}

	public void setArticleFile(Set<ArticleFile> articleFile) {
		this.articleFile = articleFile;
	}
	
	@Transient
	public String getIsFile() {
		return isFile;
	}

	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}

	@Column(name="order_id")
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(length=10,name="is_top")
	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	@Column(name="top_time")
	public Date getTopTime() {
		return topTime;
	}

	public void setTopTime(Date topTime) {
		this.topTime = topTime;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	@Column(name="visit_num")
	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
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
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
