package engineer.untitled.realm2bot.service;

import engineer.untitled.realm2bot.entities.Account;

import java.io.IOException;

public interface AccountService {
    Account getAccountInfo() throws IOException, InterruptedException;
}
