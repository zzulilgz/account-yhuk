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
public class PowerRoleUser extends Model<PowerRoleUser> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer roleId;
	private Integer userId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PowerRoleUser{" +
			", id=" + id +
			", roleId=" + roleId +
			", userId=" + userId +
			"}";
	}
}
