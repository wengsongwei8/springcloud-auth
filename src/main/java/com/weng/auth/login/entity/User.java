package com.weng.auth.login.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.weng.framework.dao.mybatis.entity.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户信息实体Bean
 *
 * @author 翁荟
 * @date 2019-05-20 10:11:49
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("u_user")
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;
	
	
	/**
     * id
     */
	@TableField(value="id")
	private String id;
	
	
	/**
     * 账号
     */
	@TableField(value="account")
	private String account;
	
	
	/**
     * 密码
     */
	@TableField(value="password")
	private String password;

	/**
	 * 机构Id
	 */
	@TableField(value="org_id")
	private String orgId;


	/**
     * 用户名称
     */
	@TableField(value="user_name")
	private String userName;
	
	
	/**
     * 电话
     */
	@TableField(value="phone")
	private String phone;
	
	
	/**
     * 邮箱
     */
	@TableField(value="email")
	private String email;
	
	
	/**
     * 性别，1男，2女
     */
	@TableField(value="sex")
	private Integer sex;
	
	
	/**
     * 头像
     */
	@TableField(value="avatar")
	private String avatar;
	
	
	/**
     * 用户类型
     */
	@TableField(value="user_type")
	private Integer userType;
	
	
	/**
     * 是否超级管理员
     */
	@TableField(value="is_super_admin")
	private Integer isSuperAdmin;
	
	
	/**
     * 是否删除，1删除，0否
     */
	@TableField(value="is_del")
	private Integer isDel;
	
	
	/**
     * 创建时间
     */
	@TableField(value="create_time",fill = FieldFill.INSERT, strategy = FieldStrategy.NOT_EMPTY)
	private Date createTime;
	
	
	/**
     * 更新时间
     */
	@TableField(value="update_time" ,fill = FieldFill.INSERT_UPDATE,strategy= FieldStrategy.NOT_EMPTY)
	private Date updateTime;
	
	
}
