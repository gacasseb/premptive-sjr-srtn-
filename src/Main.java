import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void printLista(LinkedList<Processo> listaProcessos, int totalProcessos) {
		Processo x;
		System.out.println("  ID         ArrivalTime        FinishTime          BurstTime                 TurnAround");
		for(int i = 0; i < totalProcessos; i++) {
			x = listaProcessos.get(i);
			System.out.printf("%3d        	%3d         	   %3d         	      %3d        		 %3d\n", 
					x.getIdProcesso(), x.getArrivalTime(), x.getFinishTime(), x.getBurstTime(), x.getTurnAround());
		}
	}
	
	public static void scanTempoManual(LinkedList<Processo> listaProcessos, int totalProcessos, Scanner sc) {
		int arrivalTime, burstTime;
		for(int i = 0; i < totalProcessos; i++) {
			System.out.println("Processo " + (i+1) + ":");
			System.out.print("Entre com arrivalTime: ");
			arrivalTime = sc.nextInt();
			System.out.print("Entre com burstTime: ");
			burstTime = sc.nextInt();
			Processo x = new Processo(i+1, arrivalTime, burstTime);
			x.setTempoRestante(burstTime);
			listaProcessos.add(x);
		}
	}
	
	public static void scanTempoAleatorio(LinkedList<Processo> listaProcessos, int totalProcessos) {
		int arrivalTime, burstTime;
		Random rand = new Random();
		for(int i = 0; i < totalProcessos; i++) {
			arrivalTime = rand.nextInt(101);
			burstTime = rand.nextInt(50);
			burstTime++; // para nao pegar resultado 0!!
			Processo x = new Processo(i+1, arrivalTime, burstTime);
			x.setTempoRestante(burstTime);
			listaProcessos.add(x);
		}
	}

	public static void main(String[] args) {
		LinkedList<Processo> listaProcessos = new LinkedList<>();
		EscalonadorSRTN escalonador;
		int n, flag;
		Scanner sc = new Scanner(System.in);;
		System.out.print("Entre com o total de processos: ");
		n = sc.nextInt();
		System.out.println("Entrada de Dados:");
		System.out.println("1 - Entrada Manual");
		System.out.println("2 - Entrada Aleatoria");
		flag = sc.nextInt();
		switch(flag) {
		case 1:
			scanTempoManual(listaProcessos, n, sc);
			break;
		case 2:
			scanTempoAleatorio(listaProcessos, n);
			break;
		default:
			System.out.println("Opcao invalida!!");
		}
		escalonador = new EscalonadorSRTN(listaProcessos, n);
		printLista(listaProcessos, n);
		escalonador.start();
		while(escalonador.isAlive()) 
			;
		listaProcessos = escalonador.getListaProcesso();
		printLista(listaProcessos, n);
		sc.close();
	}
}
