package cn.oyzc.dao;

import cn.oyzc.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户DAO接口
 */
@Repository
public interface AccountDao {

    //查询所有账户信息
    @Select("select * from account")
    List<Account> findAll();

    //保存账户信息
    @Insert("insert into account(name,money) values(#{name},#{money})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int saveAccount(Account account);
}