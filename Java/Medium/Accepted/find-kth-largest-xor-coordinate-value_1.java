class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] ^ matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j - 1] ^ dp[i - 1][j] ^ dp[i][j - 1] ^ matrix[i][j];
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() < k) {
                    pq.add(dp[i][j]);
                } else {
                    if (pq.peek() < dp[i][j]) {
                        pq.poll();
                        pq.add(dp[i][j]);
                    }
                }
            }
        }
        return pq.poll();
    }
}