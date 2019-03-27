package com.csy.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 资源类型
 * @author Administrator
 *
 */
@Entity
@Table(name="t_arcType")
public class ArcType {

	@Id
	private String id; // 编号
	
	@Column(length=100)
	private String name; // 资源类型名称
	
	@Column(length=1000)
	private String remark; // 描述
	
	private Integer sort; // 排序（从小到大排序）

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	
}
