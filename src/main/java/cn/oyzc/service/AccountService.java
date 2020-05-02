package cn.oyzc.service;

import cn.oyzc.domain.Account;

import java.util.List;

public interface AccountService {
    //查询所有账户信息
    List<Account> findAll();
    //保存账户信息
    int saveAccount(Account account);
}