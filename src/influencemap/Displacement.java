package influencemap;

public class Displacement {
	private double dx, dy;
	
	public Displacement(double dx_or_speed, double dy_or_route, boolean is_polar) {
		if (is_polar) {
			changeToPolar(dx_or_speed, dy_or_route);
		} else {
			this.dx = dx_or_speed;
			this.dy = dy_or_route;
		}
	}
	
	public Displacement(double dx, double dy) {
		this(dx, dy, false);
	}
	
	public Displacement(Displacement displacement) {
		dx = displacement.dx;
		dy = displacement.dy;
	}
	
	public double getDx() {
		return dx;
	}
	
	public double getDy() {
		return dy;
	}
	
	public void setDx(double dx) {
		this.dx = dx;
	}
	
	public void setDy(double dy) {
		this.dy = dy;
	}
	
	public void changeTo(Displacement displacement) {
		dx = displacement.dx;
		dy = displacement.dy;
	}
	
	public void changeTo(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void changeBy(double ax, double ay) {
		dx += ax;
		dy += ay;
	}
	
	public void changeToPolar(double speed, double route) {
		double alpha = Math.toRadians(90 - route);
		
		dx = speed * Math.cos(alpha);
		dy = speed * Math.sin(alpha);
	}
	
	public void changeByPolar(double delta_speed, double delta_route) {
		changeToPolar(speed() + delta_speed, route() + delta_route);
	}
	
	public double speed() {
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	public double route() {
		double alpha = 90.0 - Math.toDegrees(Math.atan2(dy, dx));
		
		if (alpha >= 360.0) {
			return alpha - 360.0;
		} else if (alpha < 0.0) {
			return alpha + 360.0;
		} else {
			return alpha;
		}
	}
	
	public void turnTo(double route) {
		changeToPolar(speed(), route);
	}
	
	public void turnBy(double delta_route) {
		turnTo(route() + delta_route);
	}
	
	public void changeSpeedTo(double speed) {
		changeToPolar(speed, route());
	}
	
	public void changeSpeedBy(double delta_speed) {
		changeSpeedTo(speed() + delta_speed);
	}
}
