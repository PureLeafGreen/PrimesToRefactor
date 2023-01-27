package literateprimes;

public class PrintPrimes {
  public static void main(String[] args) {
    final int SECTION = 1000;
    final int LIGNES_PAGE = 50;
    final int COLONNES = 4;

    final int ORDMAX = 30;
    int page[] = new int[SECTION + 1];
    int nombre_page;
    int PAGEOFF;
    int ROWOFFSET;
    int C;
    int K2;
    int K;
    boolean JPRIME;

    // Vive les Mac
    int ORD;
    int SQUARE;
    int N;
    int MULT[] = new int[ORDMAX + 1];

    K2 = 1;
    K = 1;
    page[1] = 2;
    ORD = 2;
    SQUARE = 9;

    while (K < SECTION) {
      do {
        K2 = K2 + 2;
        // some comments
        if (K2 == SQUARE) {
          ORD = ORD + 1;
          SQUARE = page[ORD] * page[ORD];
          MULT[ORD - 1] = K2;
        }
        N = 2;
        JPRIME = true;
        while (N < ORD && JPRIME) {
          while (MULT[N] < K2)
            MULT[N] = MULT[N] + page[N] + page[N];
          if (MULT[N] == K2)
            JPRIME = false;
          N = N + 1;
        }
      } while (!JPRIME);
      K = K + 1;
      page[K] = K2;
    }

    {
      nombre_page = 1;
      PAGEOFF = 1;
      while (PAGEOFF <= SECTION) {
        System.out.println("The First " + SECTION +
                           " Prime Numbers --- Page " + nombre_page);
        System.out.println("");
        for (ROWOFFSET = PAGEOFF; ROWOFFSET < PAGEOFF + LIGNES_PAGE; ROWOFFSET++){
          for (C = 0; C < COLONNES;C++)
            if (ROWOFFSET + C * LIGNES_PAGE <= SECTION)
              System.out.format("%10d", page[ROWOFFSET + C * LIGNES_PAGE]);
          System.out.println("");
        }
        System.out.println("\f");
        nombre_page = nombre_page + 1;
        PAGEOFF = PAGEOFF + LIGNES_PAGE * COLONNES;
      }
    }
  }
}
