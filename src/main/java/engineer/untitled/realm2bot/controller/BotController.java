package engineer.untitled.realm2bot.controller;

import engineer.untitled.realm2bot.dao.AccountDaoImpl;
import engineer.untitled.realm2bot.entities.Account;
import engineer.untitled.realm2bot.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BotController {

    private final AccountService accountService;

    BotController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(path = "/webhook", method = RequestMethod.GET)
    public ResponseEntity<Account> webHook(){
        try {
            var account = accountService.getAccountInfo();

            return new ResponseEntity<Account>(account, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Account>(new Account(), HttpStatus.I_AM_A_TEAPOT);
    }

    @RequestMapping(path = "/account-info", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountInfo(){
        try {
            var account = accountService.getAccountInfo();

            return new ResponseEntity<Account>(account, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Account>(new Account(), HttpStatus.I_AM_A_TEAPOT);
    }
}
