package ch.lauzhack.triphub.trip;

public abstract class Gateway {
	protected String name;
	protected String id;

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getId () {
		return id;
	}

	public void setId (String id) {
		this.id = id;
	}
}
