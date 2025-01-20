package TCS;

import java.util.Scanner;

public class DanceRev {

    public static int minimumMoves(String[] instructions) {
        String[] directions = {"up", "down", "left", "right"};
        int s = instructions.length;
        int[][][] dp = new int[s + 1][4][4];

        
        for (int k = 0; k <= s; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dp[k][i][j] = Integer.MAX_VALUE;
                }
            }
        }

       
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dp[0][i][j] = 0;
            }
        }

       
        for (int k = 1; k <= s; k++) {
            int instrIdx = -1;
            for (int d = 0; d < 4; d++) {
                if (directions[d].equals(instructions[k - 1])) {
                    instrIdx = d;
                    break;
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (dp[k - 1][i][j] != Integer.MAX_VALUE) {
                        if (instrIdx == i || instrIdx == j) {
                            dp[k][i][j] = Math.min(dp[k][i][j], dp[k - 1][i][j]);
                        } else {
                            dp[k][i][j] = Math.min(dp[k][i][j], dp[k - 1][instrIdx][j] + 1);
                            dp[k][i][j] = Math.min(dp[k][i][j], dp[k - 1][i][instrIdx] + 1);
                        }
                    }
                }
            }
        }

       
        int minimumMoves = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                minimumMoves = Math.min(minimumMoves, dp[s][i][j]);
            }
        }

        return minimumMoves;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        int m = Integer.parseInt(scanner.nextLine().trim());
        String[] instructions = new String[m];

       
        for (int i = 0; i < m; i++) {
            instructions[i] = scanner.nextLine().trim();
        }

       
        int result = minimumMoves(instructions);
        System.out.print(result);

        scanner.close();
    }
}
