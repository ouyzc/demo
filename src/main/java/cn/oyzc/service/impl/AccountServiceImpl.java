package cn.oyzc.service.impl;

import cn.oyzc.dao.AccountDao;
import cn.oyzc.domain.Account;
import cn.oyzc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户信息。。。");
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户信息。。。");
    }
}