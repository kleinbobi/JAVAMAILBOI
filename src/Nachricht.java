import java.util.Date;

/**
 * Kapselt in sich eine E-Mail-Nachricht. Dabei werden Anlagen in ihr
 * nicht abgespeichert
 * @author Michael Wild
 */
public class Nachricht
{
	/*
	 * Membervariablen
	 */
	/**
	 * Nummer der Nachricht im Posteingangsordner (INBOX)
	 */
	protected int nummer = -1;
	/**
	 * Absender der Nachricht
	 */
	protected String von = "absender@server.net";
	/**
	 * Empf�nger der Nachricht
	 */
	protected String an = "empfaenger@server.net";
	/**
	 * Sendedatum der Nachricht
	 */
	protected Date gesendetAm = null;
	/**
	 * Betreff der Nachricht
	 */
	protected String betreff = null;
	/**
	 * Typ der Nachricht (nur Text, HTML, Text und HTML, mit Anlagen)
	 */
	protected String contentType = null;
	/**
	 * Inhalt der Nachricht
	 */
	protected String inhalt = null;
	/**
	 * Anzahl der Anlagen der Nachricht
	 */
	protected int anzahlAnlagen = 0;

	/*
	 * Konstruktoren 
	 */
	/**
	 * Konstruktor der zum Erstellen einer neuen Nachricht dient, welche
	 * verschickt werden soll 
	 * @param von Absender der Nachricht
	 * @param an Empf�nger der Nachricht
	 * @param betreff der Nachricht
	 * @param contentType der Nachricht
	 * @param inhalt der Nachricht
	 */
	public Nachricht(String von, String an, String betreff, String contentType,
		String inhalt) 
		throws NachrichtenException {
		this.setVon(von);
		this.setAn(an);
		this.setBetreff(betreff);
		this.setContentType(contentType);
		this.setInhalt(inhalt);
	}

	/**
	 * Konstruktor der zum Erstellen einer Nachricht dient, welche im Posteingang
	 * vorhanden ist und zur Anzeige im Client herangezogen werden soll. Diesem
	 * Konstruktor werden zus�tzlich noch die Nummer der Nachricht, das
	 * Sendedatum und auch die Anzahl der Anlagen �bergeben
	 * @param von
	 * @param an
	 * @param betreff
	 * @param contentType
	 * @param inhalt
	 * @param nummer
	 * @param gesendetAm
	 * @param anzahlAnlagen
	 * @throws NachrichtenException
	 */
	public Nachricht(String von, String an, String betreff, 
		String contentType,	String inhalt, int nummer, Date gesendetAm,
		int anzahlAnlagen) 
		throws NachrichtenException {
		this(von, an, betreff, contentType, inhalt);
		this.setNummer(nummer);
		this.setGesendetAm(gesendetAm);
		this.setAnzahlAnlagen(anzahlAnlagen);
	}
	
	/*
	 * Methoden
	 */
	public String toString() {
		return "Nr.: " + this.nummer +
			" Von: " + this.von +
			" An: " + this.an +
			" Gese.: " + this.gesendetAm +
			" Betr.: " + this.betreff +
			" Cont.: " + this.contentType +
		  " Anza.: " + this.anzahlAnlagen + 
		  " Inh.: " + this.inhalt;
	}
	
	/*
	 * Getter- und Setter-Methoden
	 */
	/**
	 * Liefert die Nummer der Nachricht
	 * @return Nummer der Nachricht
	 */
	public int getNummer() {
		return this.nummer;
	}
	/**
	 * Wenn die Nummer einer Nachricht gesetzt wird, so muss diese Nummer
	 * gr��er als 0 sein, ansonsten wird ein NachrichtenException mit
	 * der entsprechenden Fehlermeldung geworfen
	 * @param nummer der Nachricht
	 * @throws NachrichtenException
	 */
	public void setNummer(int nummer) throws NachrichtenException {
		if (nummer < 1)
			throw new NachrichtenException("Nummer darf nicht kleiner 1 sein");
		this.nummer = nummer;
	}
	/**
	 * Liefert den Absender
	 * @return den Absender
	 */
	public String getVon() {
		return this.von;
	}
	/**
	 * Setzt den Absender auf die �bergebene E-Mail-Adresse. Wird kein
	 * Absender �bergeben, wird ein NachrichenException mit der entsprechenden
	 * Fehlermeldung geworfen
	 * @param von E-Mail-Adresse des Absenders
	 * @throws NachrichtenException
	 */
	public void setVon(String von) throws NachrichtenException {
		if (von == null || von.length() == 0)
			throw new NachrichtenException("Absender darf nicht leer sein");
		this.von = von;
	}
	/**
	 * Liefert den Empf�nger
	 * @return den Empf�nger
	 */
	public String getAn() {
		return this.an;
	}
	/**
	 * Setzt den Empf�nger der Nachricht. Wird kein Empf�nger �bergeben,
	 * wird ein NachrichtenException geworfen
	 * @param an Empf�nger der Nachricht
	 * @throws NachrichtenException
	 */
	public void setAn(String an) throws NachrichtenException {
		if (an == null || an.length() == 0)
			throw new NachrichtenException("Empf�nger darf nicht leer sein");
		this.an = an;
	}
	/**
	 * Liefert das Sendedatum der Nachricht
	 * @return das Sendedatum der Nachricht
	 */
	public Date getGesendetAm() {
		return this.gesendetAm;
	}
	/**
	 * Setzt das Sendedatum der Nachricht. Ist das �bergebene Datum leer, so
	 * wird ein NachrichtenException mit der entsprechenden Fehlermeldung
	 * geworfen
	 * @param gesendetAm das einzustellende Sendedatum
	 * @throws NachrichtenException
	 */
	public void setGesendetAm(Date gesendetAm) throws NachrichtenException {
		if (gesendetAm == null)
			throw new NachrichtenException("Sendedatum darf nicht leer sein");
		this.gesendetAm = gesendetAm;
	}
	/**
	 * Liefert den Betreff der Nachricht
	 * @return Betreff der Nachricht
	 */
	public String getBetreff() {
		return this.betreff;
	}
	/**
	 * Setzt den Betreff der Nachricht. Dieser darf nicht leer sein, ansonsten
	 * wird ein NachrichtenException geworfen
	 * @param betreff der Nachricht
	 * @throws NachrichtenException
	 */
	public void setBetreff(String betreff) throws NachrichtenException {
		if (betreff == null || betreff.length() == 0)
			throw new NachrichtenException("Betreff darf nicht leer sein");
		this.betreff = betreff;
	}
	/**
	 * Liefert den ContentTyp - also den Typ des Nachrichteninhaltes - zur�ck
	 * @return den ContentTyp
	 */
	public String getContentType() {
		return this.contentType;
	}
	/**
	 * Setzt den ContentTyp der Nachricht. Dieser darf nicht leer sein und muss
	 * entweder text/plain, text/html, multipart/alternative, multipart/mixed
	 * oder multipart/report sein
	 * @param contentType der zu setzen ist
	 * @throws NachrichtenException
	 */
	public void setContentType(String contentType) throws NachrichtenException {
		if (contentType == null || contentType.length() == 0)
			throw new NachrichtenException("ContentTyp darf nicht leer sein");
		if (!contentType.contains("text/plain") &&
			!contentType.contains("text/html") &&	
			!contentType.contains("multipart/alternative") &&
			!contentType.contains("multipart/mixed") &&
			!contentType.contains("multipart/report"))
			throw new NachrichtenException("Unzul�ssiger ContentTyp �bergeben");
		this.contentType = contentType;
	}
	/**
	 * Der Inhalt der Nachricht wird zur�ck geliefert. Der Inhalt einer
	 * Nachricht kann auch leer sein. In diesem Fall wird "" zur�ck geliefert
	 * @return den Inhalt der Nachricht
	 */
	public String getInhalt() {
		return this.inhalt == null || this.inhalt.length() == 0 ? "" : this.inhalt;
	}
	/**
	 * Der Inhalt der Nachricht wird gesetzt. Dieser kann auch leer - also
	 * null - sein. Wenn eine HTML-Nachricht verschickt wird, so muss dem
	 * Inhalt der aufbereitete HTML-Text �bergeben werden
	 * @param inhalt der Nachricht
	 */
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	/**
	 * Liefert die Anzahl der Anlagen zur�ck
	 * @return Anzahl der Anlagen
	 */
	public int getAnzahlAnlagen() {
		return this.anzahlAnlagen;
	}
	/**
	 * Setzt die Anzahl der Anlagen, welche nicht kleiner als 0 sein darf
	 * @param anzahlAnlagen
	 * @throws NachrichtenException
	 */
	public void setAnzahlAnlagen(int anzahlAnlagen) throws NachrichtenException {
		if (anzahlAnlagen < 0)
			throw new NachrichtenException ("Anzahl Anlagen darf nicht kleiner 0 sein");
		this.anzahlAnlagen = anzahlAnlagen;
	}
}