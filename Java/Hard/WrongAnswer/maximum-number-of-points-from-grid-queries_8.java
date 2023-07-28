class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] answer = new int[queries.length];
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int max = 0;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    int x = 1;
                    int y = 1;
                    int count = 0;
                    while (j - x >= 1 && k - y >= 1) {
                        int sum = prefixSum[j][k] - prefixSum[j][k - y] - prefixSum[j - x][k] + prefixSum[j - x][k - y];
                        if (sum > queries[i]) {
                            break;
                        }
                        count++;
                        x++;
                        y++;
                    }
                    max = Math.max(max, count);
                }
            }
            answer[i] = max;
        }
        return answer;
    }
}