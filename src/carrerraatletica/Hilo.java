
package carrerraatletica;

import javax.swing.*;

public class Hilo implements Runnable {
	
	private Corredor participant;
	private JTextArea txtAreaResult;
	
	//constructor
	public Hilo(Corredor participant, JTextArea txtAreaResult) {
		this.participant = participant;
		this.txtAreaResult = txtAreaResult;
	}
	
	@Override
	public void run() {
		int time = participant.getSpeed() * 1000;
		try{
			Thread.sleep(time);
			txtAreaResult.append(participant.getName() + " - Tiempo: " + participant.getSpeed() + "\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
