//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;


// Classe principale, con metodo main
class Esercizio {

    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i;

        System.out.println("Inserire il numero di automobili");
        n = Integer.parseInt(input.nextLine());
        String[] nomi = new String[n];
        int[] posizioni = new int[n];

        // Caricamento dei due vettori
        for (i = 0; i <= n - 1; i++) {
            System.out.println("Nome " + (i + 1) + "° automobile");
            nomi[i] = input.nextLine();
        }
        impostaVettoreRandom(posizioni);
        visualizzaVettori(nomi, posizioni);

        // Ordinamento dei vettori paralleli. Quando ordino Posizioni, ordino gli elementi corrispondenti di Nomi.
        bubbleSort(nomi, posizioni);

        // Visualizzo i valori ordinati.
        System.out.println("Posizione di arrivo");
        visualizzaVettori(nomi, posizioni);
    }
    
    public static void bubbleSort(String[] nomi, int[] posizioni) {
        
        String ts;
        int t;
        boolean scambio;
        int i, j;
        int n = nomi.length;

        scambio = true;
        i = 0;
        while (i <= n - 1 && scambio) {
            scambio = false;
            j = 0;
            while (j <= n - 2 - i) {
                if (posizioni[j] > posizioni[j + 1]) {
                    scambio = true;

                    // Prima ordino Posizioni
                    t = posizioni[j];
                    posizioni[j] = posizioni[j + 1];
                    posizioni[j + 1] = t;

                    // Per mantenere la corrispondenza fra nomi e posizioni, devo scambiare anche le celle dei nomi. In questo modo i vettori paralleli rimangono coerenti.
                    ts = nomi[j];
                    nomi[j] = nomi[j + 1];
                    nomi[j + 1] = ts;
                }
                j = j + 1;
            }
            i = i + 1;
        }
    }
    
    public static void impostaVettoreRandom(int[] posizioni) {
        int i;
        int n = posizioni.length;

        for (i = 0; i <= n - 1; i++) {
            posizioni[i] = 1 + random.nextInt(n);
        }
    }
    
    public static void visualizzaVettori(String[] nomi, int[] posizioni) {
        int i;
        int n = posizioni.length;

        for (i = 0; i <= n - 1; i++) {
            System.out.println("Auto " + nomi[i] + "; Posizione: " + posizioni[i]);
        }
    }
}
