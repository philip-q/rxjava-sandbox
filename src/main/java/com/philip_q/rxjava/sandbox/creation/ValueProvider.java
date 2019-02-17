package com.philip_q.rxjava.sandbox.creation;


import io.reactivex.Observable;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by salty on 17.02.2019.
 */
class ValueProvider {

	private String string;
	private List<Integer> numbers;

	ValueProvider setString(String string) {
		this.string = string;
		return this;
	}

	ValueProvider setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
		return this;
	}

	Observable<String> getString() {
		return Observable.just(string);
	}

	Observable<String> getDelayedString() {
		return Observable.just(string).delay(1L, TimeUnit.SECONDS);
	}
}
