package com.william.paintWizard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaintCalculation
{
	private List<Paint> listOfPaints = new ArrayList<>();
	
	public PaintCalculation()
	{
		listOfPaints = new ArrayList<>();
	}
	
	public void add(Paint paint)
	{
		listOfPaints.add(paint);
	}
	
	public List<Paint> wastesLeast(int surfaceArea)
	{
		return listOfPaints.stream()
				.filter(paint ->
				{
					if(paint.paintRemaining(paint.getTotalLitres(), paint.getCoveragePerLitre(), surfaceArea) == sortLeastPaint(surfaceArea))
					{
						return true;
					}
					else
					{
						return false;
					}
				}).collect(Collectors.toList());
	}
	
	public List<Paint> costsLeast(int surfaceArea)
	{
		return listOfPaints.stream()
				.filter(paint -> 
				{
					if(paint.getCost() * paint.numberOfBuckets(paint.getTotalLitres(), paint.getCoveragePerLitre(), surfaceArea)
							== sortLowestCost(surfaceArea))
					{
						return true;
					}
					else
					{
						return false;
					}
				}).collect(Collectors.toList());	
	}
	
	public float paintRemaining(int totalLitres, int coveragePerLitre, float surfaceArea)
	{
		int totalBuckets = numberOfBuckets(totalLitres, coveragePerLitre, surfaceArea);
		
		float remainingPaint = ((totalLitres * coveragePerLitre) * totalBuckets) % surfaceArea;
		
		return remainingPaint;
	}
	
	public int numberOfBuckets(int totalLitres, int coveragePerLitre, float surfaceArea)
	{
		int numberOfBuckets = 1;
		
		if (surfaceArea > totalLitres * coveragePerLitre)
		{
			numberOfBuckets = ((int)Math.ceil(surfaceArea / (totalLitres * coveragePerLitre)));
		}
		
		return numberOfBuckets;
	}
	
	public float sortLeastPaint(int surfaceArea)
	{
		float bestPaint = surfaceArea;
		for(int i = 0; i < listOfPaints.size(); i++)
		{
			float holding = listOfPaints.get(i).paintRemaining(listOfPaints.get(i).getTotalLitres(), listOfPaints.get(i).getCoveragePerLitre(), surfaceArea);
			if(holding < bestPaint)
			{
				bestPaint = holding;
			}
		}
		return bestPaint;
	}
	
	public double sortLowestCost(int surfaceArea)
	{
		double bestPaint = listOfPaints.get(0).getCost() * listOfPaints.get(0).numberOfBuckets(listOfPaints.get(0).getTotalLitres(), listOfPaints.get(0).getCoveragePerLitre(), surfaceArea);
		for(int i = 0; i < listOfPaints.size(); i++)
		{
			double holding = listOfPaints.get(i).getCost() * listOfPaints.get(i).numberOfBuckets(listOfPaints.get(i).getTotalLitres(), listOfPaints.get(i).getCoveragePerLitre(), surfaceArea);
			if(holding < bestPaint)
			{
				bestPaint = holding;
			}
		}
		return bestPaint;
	}
	
	public List<Paint> getPaints()
	{
		return listOfPaints;
	}
}
