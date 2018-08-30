package myspring.user.dao.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import myspring.user.vo.UserVO;

//@MyMapper
public interface UserMapper {
	@Select("select * from users where userid=#{id}")
	UserVO selectUserById(@Param("id") String userid);
	List<UserVO> selectUserList();
	
	@Insert("insert into users\r\n" + 
			"		values(#{userId},#{name},#{gender},#{city} )")
	
	void insertUser(UserVO userVO);
	void updateUser(UserVO userVO);
	void deleteUser(String id);
}

