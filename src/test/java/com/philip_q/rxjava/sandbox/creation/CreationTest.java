package com.philip_q.rxjava.sandbox.creation;


import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by salty on 17.02.2019.
 */
public class CreationTest {

	@Test
	public void testHello() {
		ValueProvider vp = new ValueProvider().setString("42");
		vp.getString().subscribe((value) -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(value);
		});
	}

	@Test
	public void delayedTest() {
		ValueProvider vp = new ValueProvider().setString("42");
		vp.getDelayedString().subscribe(System.out::println);
	}

	@Test
	public void delayedTestSuccess() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		CountDownLatch countDownLatch = new CountDownLatch(1);
		ValueProvider vp = new ValueProvider().setString("42");
		vp.getDelayedString().subscribe((value) -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(value);
			countDownLatch.countDown();
		});
		countDownLatch.await();
	}

	@Test
	public void multipleSubscribers() {
		ValueProvider vp = new ValueProvider().setString("42");

		vp.getString().subscribe(System.out::println);
		Observable<String> observable = vp.getString();
		vp.setString("not 42");
		vp.getString().subscribe(System.out::println);
		observable.subscribe(System.out::println);


	}


}
