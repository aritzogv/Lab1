package pack;

public class BDErrorConexion extends Exception {
	private static final long serialVersionUID = -421690110222813673L;

	public BDErrorConexion() {
		super();
	}

	public BDErrorConexion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BDErrorConexion(String message, Throwable cause) {
		super(message, cause);
	}

	public BDErrorConexion(String message) {
		super(message);
	}

	public BDErrorConexion(Throwable cause) {
		super(cause);
	}

}
