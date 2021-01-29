package com.hegong.service;

import com.hegong.domain.Account;

import java.util.List;

/**
 * @author 14767
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    public void saveAccount(Account account);
}
