package com.yhuk.account.domain.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
public class PowerMenuOperation extends Model<PowerMenuOperation> {

    private static final long serialVersionUID = 1L;

	private Integer menuId;
	private Integer operationId;


	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getOperationId() {
		return operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	@Override
	protected Serializable pkVal() {
		return this.menuId;
	}

	@Override
	public String toString() {
		return "PowerMenuOperation{" +
			", menuId=" + menuId +
			", operationId=" + operationId +
			"}";
	}
}
