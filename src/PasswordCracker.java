// Un oggetto di questa classe rappresenta un hacker che cerca di violare
// la password segreta per aprire il file protetto che viene ricevuto nel
// costruttore.
public class PasswordCracker {
    private PasswordGenerator passwordGenerator;
    private PasswordProtectedFile fileToCrack;
    private int password_length;

    public PasswordCracker(PasswordProtectedFile file, int password_length) {
        this.password_length = password_length;
        this.passwordGenerator = new PasswordGenerator();
        this.fileToCrack = file;
    }
    public String crack_it() {
        // TODO: continua a generaqre password tramite un generatore
        // fino a quando non ottiene la corrispondenza con la password
        // del file. A questo punto ritorna la password al chiamante.
        String generatedPassword = "N/A";
        int pwd = 0;
        do {
            //generatedPassword = "" + (int)(Math.random() * Math.pow(10d, (double)this.password_length));
            pwd++;
            generatedPassword = "" + pwd;
            System.out.println("#" + generatedPassword + "#");
        } while (!this.fileToCrack.open(generatedPassword));
        
        return generatedPassword;
    }

}
