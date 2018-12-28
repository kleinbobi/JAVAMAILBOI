import org.jetbrains.annotations.Contract;

public class Nachrichtenliste {

    protected  java.lang.String benutzername;
    private boolean debug;
    static int KEINE_SICHERUNG;
    static int KENNWORTAUTHENTIFIZIERUNG;
    private java.lang.String password;
    private java.lang.String popserver;
    protected int sicherungsart;
    protected boolean smtpAfterPop;
    protected String smtpserver;
    static int SSL_VERSCHLUESSELUNG;


    public Nachrichtenliste(String benutzername, boolean debug, String password, String popserver, int sicherungsart, boolean smtpAfterPop, String smtpserver) throws NachrichtenException{
        if(popserver == null)
            throw new NachrichtenException("POP Server nicht gesetzt");

        if(smtpserver == null)
            throw new NachrichtenException("SMTP Server nicht gesetzt");

        if(benutzername == null)
            throw new NachrichtenException("benutzername nicht gesetzt");

        if(password == null)
            throw new NachrichtenException("Password nicht gesetzt");

        if(sicherungsart <0)//TODO
            throw new NachrichtenException("Sicherung!!");
        this.benutzername = benutzername;
        this.debug = debug;
        this.password = password;
        this.popserver = popserver;
        this.sicherungsart = sicherungsart;
        this.smtpAfterPop = smtpAfterPop;
        this.smtpserver = smtpserver;
    }

    public Nachricht[] getNachrichten() throws NachrichtenException {







    }




}
