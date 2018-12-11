package com.william.paintWizard;

public class Main 
{
	public static void main(String[] args)
	{
		PaintCalculation paint = new PaintCalculation();
		
		paint.add(new Paint("CheapoMax", 20, 19.99, 10));
		paint.add(new Paint("AverageJoes", 15, 17.99, 11));
		paint.add(new Paint("DeluxourousPaints", 10, 25.00, 20));
		
		System.out.println(paint.wastesLeast(700));
		System.out.println(paint.costsLeast(330));
	}
}
