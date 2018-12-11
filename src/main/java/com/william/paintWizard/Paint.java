package com.william.paintWizard;

public class Paint extends PaintCalculation
{
	private String paintName;
	private int totalLitres;
	private double cost;
	private int coveragePerLitre;
	
	public Paint(String paintName, int totalLitres, double cost, int coveragePerLitre)
	{
		this.paintName = paintName;
		this.totalLitres = totalLitres;
		this.cost = cost;
		this.coveragePerLitre = coveragePerLitre;
	}

	@Override
	public String toString()
	{
		return paintName;
	}
		
	public String getPaintName() 
	{
		return paintName;
	}

	public void setPaintName(String paintName)
	{
		this.paintName = paintName;
	}

	public int getTotalLitres()
	{
		return totalLitres;
	}

	public void setTotalLitres(int totalLitres)
	{
		this.totalLitres = totalLitres;
	}

	public double getCost() 
	{
		return cost;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}

	public int getCoveragePerLitre() 
	{
		return coveragePerLitre;
	}

	public void setCoveragePerLitre(int coveragePerLitre)
	{
		this.coveragePerLitre = coveragePerLitre;
	}
}
