package model.exceptions;

//se fosse uma exceção RuntimeException o compilador não obriga a tratar
public class DomainException extends Exception{
	//classe que são serializable podem ser convertidas para bytes e assim podem trafegar em rede, ser gravados em arquivos.
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
	

}
