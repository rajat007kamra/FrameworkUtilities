package utilities;

public class MyException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2193467684896740533L;

	public MyException(String message) {
		CommonFunctions.log.info(message);
	}
}
