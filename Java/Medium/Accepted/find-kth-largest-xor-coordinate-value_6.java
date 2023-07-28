class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] p = new int[m][n];
        p[0][0] = matrix[0][0];
        for (int i = 1; i < m; ++i) {
            p[i][0] = p[i-1][0] ^ matrix[i][0];
        }
        for (int j = 1; j < n; ++j) {
            p[0][j] = p[0][j-1] ^ matrix[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                p[i][j] = p[i-1][j] ^ p[i][j-1] ^ p[i-1][j-1] ^ matrix[i][j];
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                pq.add(p[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}