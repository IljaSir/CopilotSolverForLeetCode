class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] xor = new int[m + 1][n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                xor[i][j] = xor[i - 1][j] ^ xor[i][j - 1] ^ xor[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                pq.offer(xor[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}