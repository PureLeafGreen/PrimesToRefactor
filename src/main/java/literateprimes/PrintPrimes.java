package literateprimes;

public class PrintPrimes {
  public static void main(String[] args) {
    final int BANANE = 1000;
    final int ROWPERPAGE = 50;
    final int CC = 4;
    final int WW = 10;

    final int ORDMAX = 30;
    int P[] = new int[BANANE + 1];
    int PAGENUMBER;
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
    P[1] = 2;
    ORD = 2;
    SQUARE = 9;

    while (K < BANANE) {
      do {
        K2 = K2 + 2;
        // some comments
        if (K2 == SQUARE) {
          ORD = ORD + 1;
          SQUARE = P[ORD] * P[ORD];
          MULT[ORD - 1] = K2;
        }
        N = 2;
        JPRIME = true;
        while (N < ORD && JPRIME) {
          while (MULT[N] < K2)
            MULT[N] = MULT[N] + P[N] + P[N];
          if (MULT[N] == K2)
            JPRIME = false;
          N = N + 1;
        }
      } while (!JPRIME);
      K = K + 1;
      P[K] = K2;
    }

    {
      PAGENUMBER = 1;
      PAGEOFF = 1;
      while (PAGEOFF <= BANANE) {
        System.out.println("The First " + BANANE +
                           " Prime Numbers --- Page " + PAGENUMBER);
        System.out.println("");
        for (ROWOFFSET = PAGEOFF; ROWOFFSET < PAGEOFF + ROWPERPAGE; ROWOFFSET++){
          for (C = 0; C < CC;C++)
            if (ROWOFFSET + C * ROWPERPAGE <= BANANE)
              System.out.format("%10d", P[ROWOFFSET + C * ROWPERPAGE]);
          System.out.println("");
        }
        System.out.println("\f");
        PAGENUMBER = PAGENUMBER + 1;
        PAGEOFF = PAGEOFF + ROWPERPAGE * CC;
      }
    }
  }
}
