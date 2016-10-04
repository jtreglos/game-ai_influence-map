package influencemap;

public class InfluenceCategory {
	private String name;
	private String color;
	private double global_weight;
	private boolean is_visible;
	
	public InfluenceCategory(String name, String color, double global_weight) {
		this.name = name;
		this.color = color;
		this.global_weight = global_weight;
	}
	
	public InfluenceCategory(String name, String color) {
		this(name, color, 1.0);
	}
	
	public InfluenceCategory(String name) {
		this(name, __generateRandomColor(), 1.0);
	}
	
	private static String __generateRandomColor() {
		int red_value = (int)(Math.random() * 256);
		int green_value = (int)(Math.random() * 256);
		int blue_value = (int)(Math.random() * 256);
		
		return String.format("%02X%02X%02X", red_value, green_value, blue_value);
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getGlobalWeight() {
		return global_weight;
	}
	
	public boolean isVisible() {
		return is_visible;
	}
	
	public void show() {
		this.is_visible = true;
	}
	
	public void hide() {
		this.is_visible = false;
	}
	
	public void toggleVisibility() {
		this.is_visible = !this.is_visible;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof InfluenceCategory))
			return false;
		InfluenceCategory other = (InfluenceCategory) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
