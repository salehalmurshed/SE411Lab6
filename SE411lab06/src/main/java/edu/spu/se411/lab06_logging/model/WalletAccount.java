package edu.spu.se411.lab06_logging.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.spu.se411.lab06_logging.exceptions.InsufficientFundsException;

public class WalletAccount {

	private static final Logger logger = LoggerFactory.getLogger(WalletAccount.class);
	private double balance;

    public WalletAccount(double balance) {
        setBalance(balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount < 0) {
			logger.warn("Attempted withdrawal with negative amount: {}", amount);
			throw new IllegalArgumentException("Cannot withdraw negative number: " + amount);
		} else if (amount > balance) {
            logger.error("Insufficient funds for withdrawal. Requested: {}, Available: {}", amount, balance);
            throw new InsufficientFundsException("Insufficient funds. Your balance is " + balance);
        } else {
            balance -= amount;
            logger.info("Withdrawal successful. Remaining balance: {}", balance);
        }
    }
    
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            logger.warn("Attempted deposit with negative amount: {}", amount);
            throw new IllegalArgumentException("Cannot deposit negative number: " + amount);
        } else {
            balance += amount;
            logger.info("Deposit successful. New balance: {}", balance);
        }
    }

    public void setBalance(double balance) {
    	if (balance < 0) {
    		logger.error("Attempted to set invalid balance: {}", balance);
			throw new IllegalArgumentException("Balance cannot be negative: " + balance);
		}
    	
    	this.balance = balance;
    	logger.debug("Balance set to: {}", balance);
	}
	
}
