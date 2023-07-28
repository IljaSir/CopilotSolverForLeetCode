class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        
        int n = board.size();
        int[][] score = new int[n][n];
        int[][] paths = new int[n][n];
        paths[n - 1][n - 1] = 1;
        int mod = 1000000007;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') {
                    score[i][j] = -1;
                    continue;
                }
                if (i == n - 1 && j == n - 1) {
                    continue;
                }
                int maxScore = 0;
                int maxPaths = 0;
                if (i + 1 < n && score[i + 1][j] != -1) {
                    int s = score[i + 1][j];
                    int p = paths[i + 1][j];
                    if (s > maxScore) {
                        maxScore = s;
                        maxPaths = p;
                    } else if (s == maxScore) {
                        maxPaths += p;
                    }
                }
                if (j + 1 < n && score[i][j + 1] != -1) {
                    int s = score[i][j + 1];
                    int p = paths[i][j + 1];
                    if (s > maxScore) {
                        maxScore = s;
                        maxPaths = p;
                    } else if (s == maxScore) {
                        maxPaths += p;
                    }
                }
                if (i + 1 < n && j + 1 < n && score[i + 1][j + 1] != -1) {
                    int s = score[i + 1][j + 1];
                    int p = paths[i + 1][j + 1];
                    if (s > maxScore) {
                        maxScore = s;
                        maxPaths = p;
                    } else if (s == maxScore) {
                        maxPaths += p;
                    }
                }
                score[i][j] = maxScore + (board.get(i).charAt(j) - '0');
                paths[i][j] = maxPaths % mod;
            }
        }
        if (score[0][0] == 0) {
            return
    }
}