package ch.lauzhack.triphub.trip;

import java.util.ArrayList;
import java.util.List;

public class Path {

	private List<Stop> path;
	
	public Path() {
		this.path = new ArrayList<>();
	}
	
	public Path(List<Stop> path) {
		this();
		this.path.addAll(path); 
	}

	public List<Stop> getPath() {
		return path;
	}

	public void setPath(List<Stop> path) {
		this.path = path;
	}
	
	public boolean isMergableAt(Stop s1, Stop s2) {
		if(this.getPath().contains(s1)) {
			if(s1.equals(s2)) {
				if(s1.getDateTime().after(s2.getDateTime())) {
					return true;
				}
			}
		} else {
			throw new IllegalArgumentException("Path/Stop invalid");
		}
		return false;
	}
}
