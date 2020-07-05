package com.sample.concurrency.Lambas;

import java.util.UUID;

public class SampleLambda {
	
	public static void main(String[] args) {
		SampleFunctionalInterface1 interface1 = ()->{
			System.out.println("Hola Mundo");
		};
		
		interface1.printHello();
		
		SampleFunctionalInterface2 interface2 = (name)->{
			System.out.println("Hello " + name);
		};
		
		interface2.printName("Ankit");
		
		SampleFunctionalInterface3 interface3 = (a, b)->(a + b);
		
		System.out.println("" + interface3.calculate(5, 14));
		
		SampleFunctionalInterface4 interface4 = SampleLambda::printGUID;
		
		interface4.printRandomId();
	}
	
	private static void printGUID() {
		System.out.println(UUID.randomUUID().toString());
	}
}
