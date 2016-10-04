package influencemap;

// import processing.core.*;

public class InfluenceMapRun {
	public static void main(String[] args) {
		double sp, rt;
		
		// PApplet.main(new String[] { "--present", "influencemap.InfluenceMapPApplet" });
		System.out.println("-- START --");
		Position p0 = new Position(100, 100);
		InfluenceCategory category = new InfluenceCategory("Category 1");
		Unit u = new Unit("Unit 1", 10, p0, category);
		System.out.println(u);
		
		u.moveBy(2, -2);
		System.out.println(u);
		u.move();
		System.out.println(u);
		sp = u.getDisplacement().speed();
		rt = u.getDisplacement().route();
		System.out.println("Speed: " + sp + " / Route: " + rt);
		
		u.moveBy(-1, 5);
		System.out.println(u);
		u.move();
		System.out.println(u);
		sp = u.getDisplacement().speed();
		rt = u.getDisplacement().route();
		System.out.println("Speed: " + sp + " / Route: " + rt);
		System.out.println("-- END --");
	}
}
