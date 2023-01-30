package literateprimes;

public class PrintPrimes {
  public static void main(String[] args) {
    final int NB_MAX_SECTION = 1000;
    final int NB_LIGNES_PAGE = 50;
    final int NB_COLONNES = 4;

    final int ORDMAX = 30;
    int page[] = new int[NB_MAX_SECTION + 1];
    int nombre_page;
    int PAGEOFF;
    int ROWOFFSET;
    int C;
    int prime_courant;
    int nombre_courant;
    boolean EST_PRIME;

    // Vive linux
    int nombre_primes;
    int SQUARE;
    int N;
    int MULT[] = new int[ORDMAX + 1];

    prime_courant = 1;
    nombre_courant = 1;
    page[1] = 2;
    nombre_primes = 2;
    SQUARE = 9;

    while (nombre_courant < NB_MAX_SECTION) {
      do {
        prime_courant = prime_courant + 2;
        // some comments
        if (prime_courant == SQUARE) {
          nombre_primes = nombre_primes + 1;
          SQUARE = page[nombre_primes] * page[nombre_primes];
          MULT[nombre_primes - 1] = prime_courant;
        }
        N = 2;
        EST_PRIME = true;
        while (N < nombre_primes && EST_PRIME) {
          while (MULT[N] < prime_courant)
            MULT[N] = MULT[N] + page[N] + page[N];
          if (MULT[N] == prime_courant)
            EST_PRIME = false;
          N = N + 1;
        }
      } while (!EST_PRIME);
      nombre_courant = nombre_courant + 1;
      page[nombre_courant] = prime_courant;
    }

    {
      nombre_page = 1;
      PAGEOFF = 1;
      while (PAGEOFF <= NB_MAX_SECTION) {
        System.out.println("The First " + NB_MAX_SECTION +
                           " Prime Numbers --- Page " + nombre_page);
        System.out.println("");
        for (ROWOFFSET = PAGEOFF; ROWOFFSET < PAGEOFF + NB_LIGNES_PAGE; ROWOFFSET++){
          for (C = 0; C < NB_COLONNES;C++)
            if (ROWOFFSET + C * NB_LIGNES_PAGE <= NB_MAX_SECTION)
              System.out.format("%10d", page[ROWOFFSET + C * NB_LIGNES_PAGE]);
          System.out.println("");
        }
        System.out.println("\f");
        nombre_page = nombre_page + 1;
        PAGEOFF = PAGEOFF + NB_LIGNES_PAGE * NB_COLONNES;
      }
    }
  }
}
