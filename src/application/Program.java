package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		try {
			//leitura dos dados
			System.out.print("Quarto número: ");
			int number = sc.nextInt();
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			//instanciação da reserva
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservas: " + reservation);
			
			//implementação da atualização das datas de reserva
			System.out.println();
			System.out.println("Entre com os dados atualizados da reserva");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());			
			
			reservation.updateDates(checkIn, checkOut);		
			System.out.println("Reservas: " + reservation);				
		} 
		catch(ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado ! ");
		}
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
