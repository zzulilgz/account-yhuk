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
public class PowerRoleOperation extends Model<PowerRoleOperation> {

    private static final long serialVersionUID = 1L;

	private Integer roleId;
	private Integer operationId;


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getOperationId() {
		return operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	@Override
	protected Serializable pkVal() {
		return this.roleId;
	}

	@Override
	public String toString() {
		return "PowerRoleOperation{" +
			", roleId=" + roleId +
			", operationId=" + operationId +
			"}";
	}
}
