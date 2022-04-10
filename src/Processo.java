
public class Processo extends Thread{
	private int id;
	private int arrivalTime;
	private int burstTime;
	private int finishTime;
	private int turnAround;
	private int tempoAtual;
	private int tempoRestante;
	private int tempoInicio;
	
	Processo(int id, int arrivalTime, int burstTime){
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.finishTime = 0;
		this.turnAround = 0;
		this.tempoAtual = 0;
		// this.tempoRestante = burstTime;
	}
	
	public void run() {
		tempoRestante--;
		if ( tempoRestante == 0 ) {
			System.out.println("Processo concluído dentro da thread! tempo atual: " + tempoAtual);
			finishTime = tempoAtual;
			turnAround = finishTime - tempoInicio;
		}
	}
	
	public int getIdProcesso() {
		return this.id;
	}
	
	public int getBurstTime() {
		return this.burstTime;
	}
	
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	public int getFinishTime() {
		return this.finishTime;
	}
	
	public int getTurnAround() {
		return this.turnAround;
	}
	
	public int getTempoRestante() {
		return this.tempoRestante;
	}

	public int getTempoInicio() {
		return this.tempoInicio;
	}

	public void setIdProcesso(int id) {
		this.id = id;
	}
	
	public void setTurnAround(int turnAround) {
		this.turnAround = turnAround;
	}
	
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	
	public void setTempoAtual(int tempoAtual) {
		this.tempoAtual = tempoAtual;
	}

	public void setTempoRestante(int tempoRestante) {
		this.tempoRestante = tempoRestante;
	}

	public void setTempoInicio(int tempoInicio) {
		this.tempoInicio = tempoInicio;
	}

	public boolean isComplete() {

		if ( tempoRestante == 0 ) {
			return true;
		}
		
		return false;
	}
}
