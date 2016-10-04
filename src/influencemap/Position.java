package influencemap;

public class Position {
	private int x,y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(Position position) {
		x = position.x;
		y = position.y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveTo(Position position) {
		x = position.x;
		y = position.y;
	}
	
	public Position moveBy(int dx, int dy) {
		x += dx;
		y += dy;
		
		return this;
	}
	
	public Position moveBy(Displacement displacement) {
		x += displacement.getDx();
		y += displacement.getDy();
		
		return this;
	}
	
	public double distance(Position position) {
		int dx = position.x - x;
		int dy = position.y - y;
		
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 1664;
		int result = 42;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Position))
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}
