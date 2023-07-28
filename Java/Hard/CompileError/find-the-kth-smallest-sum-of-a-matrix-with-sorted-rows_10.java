class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0 .length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int j = 0; j < n; j++) {
            pq.add(mat[0][j]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 1; i < m; i++) {
            PriorityQueue<Integer> temp = new PriorityQueue<Integer>(Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                for (int sum : pq) {
                    temp.add(sum + mat[i][j]);
                    if (temp.size() > k) {
                        temp.poll();
                    }
                }
            }
            pq = temp;
        }
        return pq.peek()0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    int sum = dp[j] + mat[i][l];
                    if (sum < temp[n - 1]) {
                        temp[n - 1] = sum;
                        int p = n - 1;
                        while (p > 0 && temp[p] < temp[p - 1]) {
                            int t = temp[p];
                            temp[p] = temp[p - 1];
                            temp[p - 1] = t;
                            p--;
                        }
                    }
                }
            }
            int[] t = dp;
            dp = temp;
            temp = t;
        }
        return dp[k - 1];
    }
}