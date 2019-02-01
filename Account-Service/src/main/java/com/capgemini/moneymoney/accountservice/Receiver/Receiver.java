package com.capgemini.moneymoney.accountservice.Receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.moneymoney.accountservice.resource.AccountResource;
import com.capgemini.moneymoney.transactionservice.entity.Transaction;

@Component
public class Receiver {
	@Autowired
	private AccountResource resource;

	@RabbitListener(queues = "CustomerQ")
	public void processMessage(Transaction transaction) {
		System.out.println(transaction);
		resource.updateAccountBalance(transaction);

	}

}
