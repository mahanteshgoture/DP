
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String X = "ABCBDAB";
        String Y = "BDCABA";

        LcsLength(X, Y);

    }

    private static void LcsLength(String X, String Y) {

        int m = X.length();
        int n = Y.length();

        int c[][] = new int[m + 1][n + 1];
        String b[][] = new String[m + 1][n + 1];


        for (int i = 0; i < m + 1; i++)
            c[i][0] = 0;

        for (int j = 0; j < n + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "\\";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "|";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "-";
                }
            }

        for (int i = 0; i < m + 1; i++) {

            StringBuffer sb = new StringBuffer();
            StringBuffer sb1 = new StringBuffer();

            for (int j = 0; j < n + 1; j++) {

                sb.append(c[i][j]).append(" ");
                sb1.append(b[i][j]).append(" ");
            }

            System.out.println(sb);
            System.out.println(sb1);
        }

        PrintLcs(b, X, X.length(), Y.length());
    }

    private static void PrintLcs(String[][] b, String X, int i, int j) {
        if (i == 0 || j == 0)
            return;

        if (b[i][j] == "\\") {
            PrintLcs(b, X, i - 1, j - 1);
            System.out.println(X.charAt(i-1));
        } else if (b[i][j] == "|")
            PrintLcs(b, X, i - 1, j);
        else
            PrintLcs(b, X, i, j - 1);
    }
}
