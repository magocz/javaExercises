package GoL;

import java.lang.Object;

public class Id {

	private Integer x;
	private Integer y;
	
	
	public Id(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public int hashCode() {
		return x * 31 + y;
	}
		
	public boolean equals(Object obj) {
		if (obj == null){
			return false;
		}
		Id id = (Id)obj;	
		if (this.x == id.getX() && this.y == id.getY()){
			return true;
		}
		return false;
	}
	
	public boolean equals(Id id) {
		if(this.x == id.getX() && this.y == id.getY()){
			return true;
		}

		return false;
	}


	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
}
