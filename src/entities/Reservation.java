package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Data de saída deve ser posterior a data de entrada");
		}
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
		//diff sera o nome da variável que pega a diferença entre as datas em milisegundos
		//getTime() me devolve a quantidade de milisegundos daquela data		
		long diff = checkOut.getTime() - checkIn.getTime();
		//TimeUnit é uma classe, na verdade um tipo enumerado complexo, do java que converte milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//esse método agora lança uma exceção caso aconteça algum erro
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas da reserva devem ser atualizadas para datas futuras");
		} 
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Data de saída deve ser posterior a data de entrada");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;		
	}
	
	@Override	
	public String toString() {
		return "Quarto "
				+ roomNumber
				+" , data de entrada: " //data de entrada é um dado do tipo Date que eu quero no estilo dd/MM/yyyy
				+ sdf.format(checkIn)   //Para fazer isso eu declaro um SimpleDateFormat
				+" , data de saída: " 
				+ sdf.format(checkOut)   
				+ " , "
				+ duration()
				+ " noites";
	}
	
	

}
