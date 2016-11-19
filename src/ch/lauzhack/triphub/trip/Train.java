package ch.lauzhack.triphub.trip;

public class Train extends Transport {
	public static enum Type {InterRegio, RegioExpress, TGV}
	
	private String company;
	private int load;
	private Type type;
	
	
	public Train()
	{
		company = "SBB CFF";
		load = 10;
		type = Type.InterRegio;
	}
	
	public Train(String company, int load, Type type)
	{
		this.company = company;
		this.load = load;
		this.type = type;
	}

	public String getCompany() 
	{
		return company;
	}

	public void setCompany(String company) 
	{
		this.company = company;
	}

	public int getLoad() 
	{
		return load;
	}

	public void setLoad(int load) 
	{
		this.load = load;
	}

	public Type getType() 
	{
		return type;
	}

	public void setType(Type type) 
	{
		this.type = type;
	}
}
