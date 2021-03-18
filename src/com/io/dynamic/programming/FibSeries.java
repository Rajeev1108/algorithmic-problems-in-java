package com.io.dynamic.programming;

public class FibSeries {

	public static void main(String[] args) {
	float output = callFib(6.0);
	System.out.println("here is your output "+ output);

	}

	public static float callFib(double d) {
		// TODO Auto-generated method stub
		if (d < 1)
			return (float) d;
		else
			return callFib(d - 1) + callFib(d - 2);
	}

}
