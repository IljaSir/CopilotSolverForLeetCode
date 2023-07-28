class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int M = board.size();
        int N = M;
        int[][][] dp = new int[M][N][2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = 0;
            }
        }
        dp[M - 1][N - 1][0] = 0;
        dp[M - 1][N - 1][1] = 1;
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == M - 1 && j == N - 1) {
                    continue;
                }
                if (board.get(i).charAt(j) == 'X') {
                    continue;
                }
                int max = Integer.MIN_VALUE;
                int count = 0;
                for (int x = i + 1; x >= i && x >= i - 1; x--) {
                    for (int y = j + 1; y >= j && y >= j - 1; y--) {
                        if (x >= M || y >= N) {
                            continue;
                        }
                        if (dp[x][y][0] > max) {
                            max = dp[x][y][0];
                            count = dp[x][y][1];
                        } else if (dp[x][y][0] == max) {
                            count = (count + dp[x][y][1]) % 1000000007;
                        }
                    }
                }
                if (max != Integer.MIN_VALUE) {
                    if (board.get(i).charAt(j) != 'E') {
                        max += board.get(i).charAt(j) - '0';
                    }
                    dp[i][j][0] = max;
                    dp[i][j][1] = count;
                }
            }
        }
        return dp[0][0];
    }
}