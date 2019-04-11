package com.yhuk.account.domain.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-11
 */
public class PowerMenu extends Model<PowerMenu> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 父节点Id
     */
	private Integer parentId;
    /**
     * 菜单名称
     */
	private String name;
    /**
     * 图标标识
     */
	private String iconFont;
    /**
     * 路由
     */
	private String path;
    /**
     * 是否是叶节点
     */
	private Boolean isLeaf;
    /**
     * 菜单等级
     */
	private Integer level;
    /**
     * 排序权重
     */
	private Integer sort;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconFont() {
		return iconFont;
	}

	public void setIconFont(String iconFont) {
		this.iconFont = iconFont;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getLeaf() {
		return isLeaf;
	}

	public void setLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PowerMenu{" +
			", id=" + id +
			", parentId=" + parentId +
			", name=" + name +
			", iconFont=" + iconFont +
			", path=" + path +
			", isLeaf=" + isLeaf +
			", level=" + level +
			", sort=" + sort +
			"}";
	}
}
