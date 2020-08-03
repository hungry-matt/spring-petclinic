package org.springframework.samples.petclinic.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

	@Test
	public void testPay() {
		Payment payment = new CashPerf();
		Store store = new Store(payment);
		store.buySomething(1100);
	}
}
