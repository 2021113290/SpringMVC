package com.example.springmvcdemo.mapper;

import com.example.springmvcdemo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    UserInfo getUserInfoById(Integer id);

    /**
     * 获得所有用户信息
     * @return
     */
    List<UserInfo> getAll();
    Integer add(UserInfo userInfo);
    Integer update(Integer id,String name);
    Integer deleteById(Integer id);

    /**
     * 测试<if></if>使用
     * @param userInfo
     * @return
     */
    int add2(UserInfo userInfo);

    /**
     * 测试<trim></trim>使用
     * @param userInfo
     * @return
     */
    int add3(UserInfo userInfo);

    /**
     * <where></where>使用以及等效的<trim></trim>写法：
     * 1.要配合if标签一起使用
     * 2.删除最前面的 and关键字
     * 3.如果where标签里没有内容，不会生成where
     * @param username
     * @param password
     * @return
     */
    List<UserInfo> getListByCondition(String username,String password);

    /**
     * <set></set>使用：
     * 1.配合if
     * 2.自动去掉最后一个英文逗号
     * @param userInfo
     * @return
     */
    int update2(UserInfo userInfo);

    /**
     * <foreach></foreach>使用
     * @param ids
     * @return
     */
    int delete2(List<Integer> ids);

}
