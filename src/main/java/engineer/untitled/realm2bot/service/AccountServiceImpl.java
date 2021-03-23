package engineer.untitled.realm2bot.service;

import engineer.untitled.realm2bot.dao.AccountDao;
import engineer.untitled.realm2bot.entities.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account getAccountInfo()
            throws IOException, InterruptedException {
        LOGGER.info("Get some account information!");
        return accountDao.getAccountInfo();
    }

}
