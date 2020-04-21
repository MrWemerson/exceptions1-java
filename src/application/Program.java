package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		
		System.out.print("Quarto n�mero: ");
		int number = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de sa�da (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de sa�da deve ser posterior a data de entrada");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservas: " + reservation);
			
			//implementa��o da atualiza��o da data
			System.out.println();
			System.out.println("Entre com os dados atualizados da reserva");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de sa�da (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//implementa��o de regra de valida��o ( n�o pode atualizar datas, se as datas n�o forem futuras )
			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Erro na reserva: " + error);
			}else {
				System.out.println("Reservas: " + reservation);				
			}			
		}
		
		
		
		
		
		
		
		
		sc.close();
	}

}
