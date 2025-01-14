public class PasswordBreaker {
    final static int PASSWORD_LENGTH = 5;

    public static void main(String[] args) {
        // viene creato un file protetto da una password segreta ...
        PasswordProtectedFile file = new PasswordProtectedFile(PASSWORD_LENGTH);
        // e un cracker che deve scoprire la password del file
        //PasswordCracker cracker = new PasswordCracker(file, PASSWORD_LENGTH);
        PasswordCrackerThreaded crackerOne = new PasswordCrackerThreaded(file, PASSWORD_LENGTH, 1);
        PasswordCrackerThreaded crackerTwo = new PasswordCrackerThreaded(file, PASSWORD_LENGTH, 2);
        crackerOne.setOtherThread(crackerTwo);
        crackerTwo.setOtherThread(crackerOne);

        System.out.println("Un file password protected e' stato creato. ");
        System.out.println("Stiamo cercando di violare la password... ");
        System.out.println();
        //Cronometro crono = new Cronometro();
        //crono.start();
        // String secret_password = cracker.crack_it();
        crackerOne.start();
        crackerTwo.start();
        
        //crono.stop();
        //System.out.println("La password segreta: " + secret_password);
        //System.out.println("e' stata violata in: " + crono.elapsed() + " millisecondi");
    }
}