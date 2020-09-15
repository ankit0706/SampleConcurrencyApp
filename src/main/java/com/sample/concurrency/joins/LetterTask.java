package com.sample.concurrency.joins;

import java.util.concurrent.Callable;
/**
 * Reversal of strings returned by Callable
 * @author AANU
 *
 */
public class LetterTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		String ret = "";
		for(int i =0; i< Constants.BRANDS.size(); i++) {
			String str = Constants.BRANDS.get(i);
			ret = ret + ", " + reverseString(str);
			System.out.println(ret);
		}
		return ret;
	}
	
	public String reverseString(String sample) {
		int stringLength = sample.length();
		StringBuilder sb = new StringBuilder();
		for(int i=stringLength-1; i>=0; i--) {
			char s = sample.charAt(i);
			sb.append(s);
		}
		return sb.toString();
	}
}
