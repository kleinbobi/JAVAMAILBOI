/**
 * Stellt ein NachrichtenException dar, welches alle auftretenden
 * Laufzeitfehler des Packages repr�sentiert. Ein NachrichtenException
 * wird beispielsweise geworfen, falls eine Nachricht ohne Empf�nger
 * verschickt werden soll
 * @author Michael Wild
 */
public class NachrichtenException extends Exception
{
	public NachrichtenException(String msg) {
		super(msg);
	}
}
