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
	
	public void mergePaths(Path p, Stop s) {
		Path p2 = new Path();
		for (Stop st : p.getPath()) {
			if(st.equals(s)) {
				break;
			}
			p2.getPath().add(st);
		}
		p2.getPath().add(s);
		boolean add = false;
		for (int i = 0; i < p.getPath().size(); i++) {
			if(add) {
				p2.getPath().add(p.getPath().get(i));
			}
			if(p.getPath().get(i).equals(s)) {
				add = true;
			}
		}
		this.path = p2.getPath();
	}
	
	public boolean isMergableAt(Stop s1, Stop s2) {
		if(this.getPath().contains(s1)) {
			if(s1.equals(s2)) {
				if(s1.getDateTime().before(s2.getDateTime())) {
					return true;
				}
			}
		} else {
			throw new IllegalArgumentException("Path/Stop invalid");
		}
		return false;
	}

	@Override
	public String toString () {
		String string = "";
		for (Stop stop : path) {
			string += stop.getStation().getName()+" @ "+stop.getDateTime();
		}
		return string;
	}
}
