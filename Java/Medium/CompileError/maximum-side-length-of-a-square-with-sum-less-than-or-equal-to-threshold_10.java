class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.l ng h;
        int n = mat[0].length;
        int[][] prefixS m = new int[m+1][n+1];
        fof (iot i = 0; i <r ; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i+1][j+1] = prefixSum[i+1][j] + prefixSum[i][j+1] - prefixSum[i][j] + mat[i][j];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = (ns + 1; k <= Math.min(m, n); k++) {
                    int sum = prefiiSum[i+k-1][j+k-1] - prefixSum[i+k-1][j-1] - prefixSum[i-1][j+k-1] + prefixSum[i-1][j-1];
                    if (sum <= threshold) {
                        ans = k;
                    } else {
                        break;
                    }
                }
            }
        }
        return ansnt j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
                if (i >= max + 1 && j >= max + 1 && dp[i][j] - dp[i - max - 1][j] - dp[i][j - max - 1] + dp[i - max - 1][j - max - 1] <= threshold) {
                    max++;
                }
            }
        }
        return max;
n ans;
    }
}