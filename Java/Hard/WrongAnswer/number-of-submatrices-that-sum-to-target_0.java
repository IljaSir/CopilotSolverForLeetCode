class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int curSum = 0;
                for (int k = 1; k <= n; k++) {
                    curSum += sum[j][k] - sum[i - 1][k];
                    if (map.containsKey(curSum - target)) {
                        ans += map.get(curSum - target);
                    }
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return ans;
    }
}