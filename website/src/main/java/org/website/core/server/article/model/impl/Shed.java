package org.website.core.server.article.model.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "gm_website_shed")
public class Shed {

	/* 栏目id */
	private Integer id;
	/* 栏目名称 */
	private String name;
	/* 所属管理员 */
	private String username;
	/* 链接地址 */
	private String shedUrl;
	/* 是否可见 */
	private Integer visit;
	/* 栏目-文章 一对多 */
	private Set<Article> articles = new HashSet<Article>();
    /*父栏目-子栏目 一对多*/
	private Shed shedparent;
    /*子栏目-父栏目 多对一*/
	private List<Shed> shedchild = new ArrayList<Shed>();
	/* 是否单页  1为单页 2为多页 3为下载也*/
	private Integer singlePage=2;
	
	
	private Integer orderId;//栏目排序Id

	public Shed() {
		// TODO Auto-generated constructor stub
	}

	public Shed(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	@Column(length = 10)
	public Integer getVisit() {
		return visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}

	@OneToMany(mappedBy = "sheds" , fetch = FetchType.EAGER)
	@OrderBy("isTop DESC,id DESC")

	
		public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "parent_id")
	public Shed getShedparent() {
		return shedparent;
	}

	public void setShedparent(Shed shedparent) {
		this.shedparent = shedparent;
	}

	@OneToMany(cascade = { CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "shedparent" , fetch = FetchType.EAGER)
	@OrderBy("orderId ASC")
	public List<Shed> getShedchild() {
		return shedchild;
	}

	public void setShedchild(List<Shed> shedchild) {
		this.shedchild = shedchild;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shed other = (Shed) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Column(length = 50 , name="shed_url")
	public String getShedUrl() {
		return shedUrl;
	}

	public void setShedUrl(String shedUrl) {
		this.shedUrl = shedUrl;
	}

	public Integer getSinglePage() {
		return singlePage;
	}

	public void setSinglePage(Integer singlePage) {
		this.singlePage = singlePage;
	}

	
	@Column(name="order_id")
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
