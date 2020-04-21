package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		//diff sera o nome da vari�vel que pega a diferen�a entre as datas em milisegundos
		//getTime() me devolve a quantidade de milisegundos daquela data		
		long diff = checkOut.getTime() - checkIn.getTime();
		//TimeUnit � uma classe, na verdade um tipo enumerado complexo, do java que converte milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "As datas da reserva devem ser atualizadas para datas futuras";
		} 
		if(!checkOut.after(checkIn)) {
			return "Data de sa�da deve ser posterior a data de entrada";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;//se retornar nulo � porque n�o deu nenhum erro
	}
	
	@Override	
	public String toString() {
		return "Quarto "
				+ roomNumber
				+" , data de entrada: " //data de entrada � um dado do tipo Date que eu quero no estilo dd/MM/yyyy
				+ sdf.format(checkIn)   //Para fazer isso eu declaro um SimpleDateFormat
				+" , data de sa�da: " 
				+ sdf.format(checkOut)   
				+ " , "
				+ duration()
				+ " noites";
	}
	
	

}
