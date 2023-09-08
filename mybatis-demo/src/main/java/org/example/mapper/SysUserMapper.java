package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.domain.SysUser;

import java.util.List;

/**
 * @author LiuYunLong
 */
public interface SysUserMapper {
	 /**
	  * 查询用户列表
	  *
	  * @return {@link List}<{@link SysUser}>
	  */
	 List<SysUser> selectList(@Param("username") String username);

	 /**
	  * 新增
	  *
	  * @param sysUser
	  * @return boolean
	  */
	 boolean save(SysUser sysUser);

	 /**
	  * 修改
	  *
	  * @param sysUser
	  * @return boolean
	  */
	 boolean update(SysUser sysUser);


	 /**
	  * 删除
	  *
	  * @param userId
	  * @return boolean
	  */
	 boolean delete(Long userId);

}
