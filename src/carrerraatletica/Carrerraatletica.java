
package carrerraatletica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Carrerraatletica extends JFrame {

	JLabel lblRegister = new JLabel("Registra Corredor");
	JTextField txtFieldName = new JTextField("");
	JButton btnRegister = new JButton("Resgistrado");
	JLabel lblRacers = new JLabel("Corredores Registrados");
	JTextArea txtAreaRacers = new JTextArea();
	JLabel lblResult = new JLabel("Resultados");
	JTextArea txtAreaResult = new JTextArea();
	JButton btnStart = new JButton("Iniciar");
	JButton btnRestart = new JButton("Reiniciar");
	JButton btnFinish = new JButton("Terminar");
	
	//Corredores 
	Corredor[] participants = new Corredor[5];
	int CorredorsCount = 0;
	
	public Carrerraatletica() {
	    setTitle("R5 Carrera Atletica");
	    setSize(550,600);
	    setLayout(null);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
	    
	    getContentPane().add(lblRegister);
	    getContentPane().add(txtFieldName);
	    getContentPane().add(btnRegister);
	    getContentPane().add(lblRacers);
	    getContentPane().add(txtAreaRacers);
	    getContentPane().add(lblResult);
	    getContentPane().add(txtAreaResult);
	    getContentPane().add(btnStart);
	    getContentPane().add(btnRestart);
	    getContentPane().add(btnFinish);
	    
	    
	    lblRegister.setBounds(10, 10, 380, 30);
	    txtFieldName.setBounds(7, 40, 300, 40);
	    btnRegister.setBounds(330, 40, 200, 40);
	    lblRacers.setBounds(10, 90, 380, 30);
	    txtAreaRacers.setBounds(10, 130, 530, 180);
	    lblResult.setBounds(10, 330, 420, 30);
	    txtAreaResult.setBounds(10, 370, 330, 180);
	    btnStart.setBounds(350, 368, 190, 60);
	    btnRestart.setBounds(350, 428, 190, 60);
	    btnFinish.setBounds(350, 488, 190, 60);
	    
	    
	    btnRegister.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				participants[CorredorsCount] = new Corredor(txtFieldName.getText());
				participants[CorredorsCount].setSpeed();
				txtFieldName.setText("");
				
				if(CorredorsCount < 4){
					txtAreaRacers.append(CorredorsCount+1 + " _ " + participants[CorredorsCount].getName() + "\n");
				} else {
					txtAreaRacers.append(CorredorsCount+1 + " _ " + participants[CorredorsCount].getName());
				}
				
				CorredorsCount++;
			} catch (Exception err){
				JOptionPane.showMessageDialog(null, "No se puede regirtrar mas corredores");
			}
		}
	    });
	    
	    btnStart.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    Thread thread[] = new Thread[participants.length];
			    Hilo Corredor[] = new Hilo[participants.length];
			    
			    try{
				    if(CorredorsCount == participants.length){
					    for (int i = 0; i < participants.length; i++) {
					    Corredor[i] = new Hilo(participants[i], txtAreaResult);
					    thread[i] = new Thread(Corredor[i]);
					    thread[i].start();
					    
				    }
				    }
			    } catch (Exception err) {
				    System.out.println(err);
			    }
		    }
	    });
	    
	    btnFinish.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    System.exit(0);
		    }
	    });
	}
	
	public static void main(String[] args) {
		new Carrerraatletica();
	
	}
	
}
