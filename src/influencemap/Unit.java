package influencemap;

import java.util.*;

public class Unit {
	private int unit_id;
	private String name;
	private double strength;
	private Position position;
	private Displacement displacement;
	private List<InfluenceCategory> categories;
	
	public Unit(String name, double strength, Position position, Displacement displacement, List<InfluenceCategory> categories) {
		this.unit_id = UUID.randomUUID().hashCode();
		this.name = name;
		this.strength = strength;
		this.position = new Position(position);
		this.displacement = displacement;
		this.categories = new ArrayList<InfluenceCategory>(categories);
	}
	
	public Unit(String name, double strength, Position position, Displacement displacement, InfluenceCategory category) {
		this(name, strength, position, displacement, Arrays.asList(category));
	}
	
	public Unit(String name, double strength, Position position, List<InfluenceCategory> categories) {
		this(name, strength, position, new Displacement(0, 0), categories);
	}
	
	public Unit(String name, double strength, Position position, InfluenceCategory category) {
		this(name, strength, position, Arrays.asList(category));
	}
	
	public Unit(Unit unit) {
		unit_id = unit.unit_id;
		name = unit.name + " - copie";
		strength = unit.strength;
		position = new Position(unit.position);
		categories = new ArrayList<InfluenceCategory>(unit.categories);
	}
	
	public int getUnitId() {
		return unit_id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getStrength() {
		return strength;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public Position moveBy(int dx, int dy) {
		if (displacement == null) {
			displacement = new Displacement(dx, dy);
		} else {
			displacement.changeTo(dx, dy);
		}
		
		return position.moveBy(displacement);
	}
	
	public Position move() {
		if (displacement != null) {
			return position.moveBy(displacement);
		} else {
			return null;
		}
	}
	
	public Displacement getDisplacement() {
		return displacement;
	}
	
	public void setDisplacement(Displacement displacement) {
		if (this.displacement == null) {
			this.displacement = new Displacement(displacement);
		} else {
			this.displacement.changeTo(displacement);
		}
	}
	
	public boolean hasCategory(InfluenceCategory category) {
		return categories.contains(category);
	}
	
	public void addCategory(InfluenceCategory category) {
		categories.add(category);
	}
	
	public void removeCategory(InfluenceCategory category) {
		categories.remove(category);
	}
	
	@Override
	public String toString() {
		String cats = categories.toString();
		return name + " : " + strength + " / " + displacement.speed() + " / " + displacement.route() + " / " + cats + " " + position;
	}

	@Override
	public int hashCode() {
		return unit_id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Unit))
			return false;
		
		Unit other = (Unit)obj;
		if (unit_id != other.unit_id)
			return false;
		
		return true;
	}
	
	
}
