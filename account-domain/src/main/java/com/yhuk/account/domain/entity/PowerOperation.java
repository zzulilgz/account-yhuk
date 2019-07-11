package com.yhuk.account.domain.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 操作表，button,href等
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
public class PowerOperation extends Model<PowerOperation> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 名称
     */
	private String name;
    /**
     * 操作类型，button,href...
     */
	private String type;
    /**
     * 路由
     */
	private String path;
    /**
     * 背景色
     */
	private String bgColor;
    /**
     * 备注
     */
	private String remark;

	private Integer menuId;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PowerOperation{" +
			", id=" + id +
			", name=" + name +
			", type=" + type +
			", path=" + path +
			", bgColor=" + bgColor +
			", remark=" + remark +
			"}";
	}
}
