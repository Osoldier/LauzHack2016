package ch.lauzhack.triphub.trip;

public class Stop {
	private String name;
	private double latitude;
	private double longitude;
	
	public Stop(String name, double latitude, double longitude)
	{
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getLatitude() 
	{
		return latitude;
	}

	public boolean setLatitude(double latitude) 
	{
		if(latitude > 90.0 || latitude < -90.0)
			return false;
		
		this.latitude = latitude;
		return true;
	}

	public double getLongitude() 
	{
		return longitude;
	}

	public boolean setLongitude(double longitude) 
	{
		if(longitude > 180.0 || longitude < -180.0)
			return false;
		this.longitude = longitude;
		return true;
	}
	
	
}
