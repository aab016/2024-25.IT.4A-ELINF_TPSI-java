import java.util.Random;

// Un oggetto di questa classe rappresenta un generatore di password
// casuali di una determinata lunghezza.
// Le password devono essere composte da soli CARATTERI MAIUSCOLI.
public class PasswordGenerator {

    // metodo che genera una password di lunghezza password_length
    // e la ritorna al chiamante.
    public String generate(int password_length) {
        // TODO: genera una password causale composta da sole
        // lettere maiuscole.
        String generatedPassword =  "" + (int)(Math.random() * Math.pow(10d, (double)password_length));
        System.out.println("generatedPassword: " + generatedPassword);

        return generatedPassword;
    }
}
