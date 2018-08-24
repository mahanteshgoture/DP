public class DPRodCutting {

    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(rodCut(price, 8));

    }

    private static int rodCut(int[] price, int n) {
        int[][] table = new int[n + 1][n + 1];
        String[][] b = new String[n + 1][n + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    table[i][i] = 0;
                    b[i][j] = "0";
                } else if (i > j) {
                    table[i][j] = table[i - 1][j];
                    b[i][j] = "d";
                } else {
                    table[i][j] = Integer.max(table[i - 1][j], price[i - 1] + table[i][j - i]);

                    if (table[i - 1][j] < price[i - 1] + table[i][j - i])
                        b[i][j] = "i";
                    else
                        b[i][j] = "d";
                }
            }

        for (int i = 0; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j <= n; j++) {
                sb.append(b[i][j] + "\t");
            }

            System.out.println(sb);
        }

        printRodCuts(b, price, n, n);

        return table[n][n];
    }

    private static void printRodCuts(String[][] b, int[] price, int i, int j) {
        if (i == 0 || j == 0)
            return;

        if (b[i][j] == "d")
            printRodCuts(b, price, i - 1, j);
        else if (b[i][j] == "i") {
            printRodCuts(b, price, i, j - i);
            System.out.println("Position:" + (i - 1) + " Price:" + price[i - 1]);
        }
    }
}