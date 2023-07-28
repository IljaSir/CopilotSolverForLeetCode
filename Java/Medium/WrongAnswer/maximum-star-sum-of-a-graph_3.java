class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        int n = vals.length;
        int[] degree = new int[n];
        int[] sum = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return degree[i2] - degree[i1];
            }
        });
        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }
        int[] dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            int cur = pq.poll();
            sum[cur] = vals[cur];
            for (int j = k; j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j-1] + sum[cur]);
            }
            for (int[] edge : edges) {
                if (edge[0] == cur) {
                    sum[edge[1]] += vals[cur];
                }
                if (edge[1] == cur) {
                    sum[edge[0]] += vals[cur];
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}