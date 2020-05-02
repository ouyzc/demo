package cn.oyzc.controller;

import cn.oyzc.domain.Account;
import cn.oyzc.dto.ResultData;
import cn.oyzc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<Account>> findAll(Model model){
        System.out.println("表现层：查询所有账户信息...");
        List<Account> list = accountService.findAll();
        for(Account account : list){
            System.out.println(account);
        }
        model.addAttribute("list",list);
        return ResultData.data(list);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultData<Account> saveAccount(@RequestBody Account account) {
        if (account.getName() == null || account.getName().equals("")) {
            return ResultData.data("传入NULL值");
        }
        accountService.saveAccount(account);
        if (account.getId() > 0) {
            return ResultData.data(account);
        }
        return ResultData.data("插入失败");
    }
}