package edu.spu.se411.lab06_logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.spu.se411.lab06_logging.exceptions.InsufficientFundsException;
import edu.spu.se411.lab06_logging.model.WalletAccount;

public class App {
	
	static Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		logger.info("Application is Starting...");

	    WalletAccount account = new WalletAccount(1000);
	    logger.debug("Wallet account created");

	    try {

	        account.withdraw(1500);
	        logger.debug("Withdraw performed");

	    } catch (InsufficientFundsException e) {

	        logger.error("Insufficient funds exception thrown", e);

	    }

	    try {

	        account.deposit(-100);
	        logger.debug("Deposit performed");

	    } catch (IllegalArgumentException e) {

	        logger.warn("Invalid argument provided to deposit operation", e);

	    }

	    logger.info("Application is Ending...");
	}

}
