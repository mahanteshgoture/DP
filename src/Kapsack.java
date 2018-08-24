public class Kapsack {

    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(Kapsack.knapSack(W, wt, val, n));

        int val1[] = new int[]{0,60, 100, 120};
        int wt1[] = new int[]{0,10, 20, 30};
        int W1 = 50;
        int n1 = val1.length-1;
        System.out.println(Kapsack.knapSack1(W1, wt1, val1, n1));
    }

    private static int knapSack(int W, int w[], int val[], int n) {

        int k[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    k[i][j] = 0;
                else if (j < w[i - 1])
                    k[i][j] = k[i - 1][j];
                else {
                    k[i][j] = Integer.max(k[i - 1][j],
                            val[i - 1] + k[i - 1][j - w[i - 1]]);
                }
            }
        System.out.println("n," + n + " w " + W);
        return k[n][W];
    }

    private static int knapSack1(int W, int w[], int val[], int n) {

        int k[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    k[i][j] = 0;
                else if (j < w[i])
                    k[i][j] = k[i - 1][j];
                else {
                    k[i][j] = Integer.max(k[i - 1][j],
                            val[i] + k[i - 1][j - w[i]]);
                }
            }
        System.out.println("n," + n + " w " + W);
        return k[n][W];
    }
}
