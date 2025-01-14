// Un oggetto di questa classe rappresenta un hacker che cerca di violare
// la password segreta per aprire il file protetto che viene ricevuto nel
// costruttore.
public class PasswordCrackerThreaded extends Thread {
    private PasswordGenerator passwordGenerator;
    private PasswordProtectedFile fileToCrack;
    private int password_length;
    private int threadNumber;
        private PasswordCrackerThreaded otherThread;
    
        public PasswordCrackerThreaded(PasswordProtectedFile file, int password_length, int threadNumber) {
            
            this.password_length = password_length;
            this.passwordGenerator = new PasswordGenerator();
            this.fileToCrack = file;
            this.threadNumber = threadNumber;

            System.out.println("#" + this.threadNumber + "#costruttore");
        }
        public String crack_it() {
            // TODO: continua a generaqre password tramite un generatore
            // fino a quando non ottiene la corrispondenza con la password
            // del file. A questo punto ritorna la password al chiamante.
            String generatedPassword = "N/A";
            int pwd = 0;
            do {
                generatedPassword = "" + (int)(Math.random() * Math.pow(10d, (double)this.password_length));
                //pwd++;
                //generatedPassword = "" + pwd;
                System.out.println("#" + threadNumber + "#"+ generatedPassword + "#");
            } while (!this.fileToCrack.open(generatedPassword) && !this.isInterrupted());
            
            if (this.isInterrupted()) {
                System.out.println("#" + threadNumber + "#interrupted while "+ generatedPassword + "#");
                generatedPassword = "N/A";
            }
            return generatedPassword;
        }
    
        public void run() {
            System.out.println("#" + this.threadNumber + "#run");
            Cronometro crono = new Cronometro();
            crono.start();
            String secret_password = this.crack_it();
            crono.stop();
            System.out.println("#" + this.threadNumber + "#La password segreta: " + secret_password);
            System.out.println("#" + this.threadNumber + "#e' stata violata in: " + crono.elapsed() + " millisecondi");

            if (this.otherThread.isAlive()) {
                System.out.println("#" + this.threadNumber + "#call interrupt on other thread");
                this.otherThread.interrupt();
            } else {
                System.out.println("#" + this.threadNumber + "#other thread was not alive");
            }
            
        }
        public void setOtherThread(PasswordCrackerThreaded otherThread) {
            // TODO Auto-generated method stub
            this.otherThread = otherThread;
    }

}
