package com;

import io.reactivex.Observable;
import io.reactivex.observers.DefaultObserver;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			/*Observable<String> str = Observable.just("Hello");
			
			str.subscribe(new DefaultObserver() {
				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					System.out.println("Completed");
				}
				@Override
				public void onError(Throwable e) {
					// TODO Auto-generated method stub
					System.out.println(e);
				}
				@Override
				public void onNext(Object t) {
					// TODO Auto-generated method stub
				System.out.println(t);	
				}
				
			});
			System.out.println("Normal Flow");*/
			Integer num[]= {10,20,30,40,50,60};
			Observable<Integer> obj = Observable.fromArray(num);
			
			/*obj.subscribe(data->System.out.println(data),
					error->System.out.println(error),
					()->System.out.println("completed"));
			*/
			obj.subscribe(data->System.out.println(data));
			System.out.println("Normal Statement");
	}

}
