
package carrerraatletica;

import java.util.Random;
public class Corredor {
	private String name;
	private int speed;
	Random rand = new Random();
	
	public Corredor(String name) {
		this.name = name;
		this.speed = rand.nextInt(31);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSpeed()  {
		return speed;
	}
	
	public void setSpeed() {
		this.speed = speed;
	}
	
}
