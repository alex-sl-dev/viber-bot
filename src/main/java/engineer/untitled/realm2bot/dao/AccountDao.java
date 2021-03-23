package engineer.untitled.realm2bot.dao;

import engineer.untitled.realm2bot.entities.Account;

import java.io.IOException;

public interface AccountDao {
    Account getAccountInfo() throws IOException, InterruptedException;
}
