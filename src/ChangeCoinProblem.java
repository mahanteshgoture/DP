public class ChangeCoinProblem {

    public static void main(String[] args) {
        int[] Coins = new int[]{0, 1, 2, 3, 4, 5};
        int n = 6;

        int[][] table = new int[Coins.length][n];

        for (int i = 0; i < Coins.length; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    table[i][j] = 1;
                    continue;
                }

                if (i == 0) {
                    table[i][j] = 0;
                    continue;
                }

                if (i > j)
                    table[i][j] = table[i - 1][j];
                else
                    table[i][j]=table[i - 1][j]+ table[i][j-i];

            }
        }

        for(int i=0;i<Coins.length;i++) {
            StringBuffer sb=new StringBuffer();
            for (int j = 0; j < n; j++){
                sb.append(table[i][j] + " ");
            }
            System.out.println(sb);
        }

    }
}
