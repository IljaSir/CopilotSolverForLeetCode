class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        int n = vals.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] dp = new int[n];
        int[] tmp = new int[n];
        int[] sum = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = vals[i];
            count[i] = 1;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                int max = 0;
                for (int v : graph[j]) {
                    max = Math.max(max, dp[v]);
                }
                tmp[j] = max + sum[j];
            }
            int[] t = dp;
            dp = tmp;
            tmp = t;
            for (int j = 0; j < n; j++) {
                for (int v : graph[j]) {
                    sum[j] += vals[v];
                    count[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i] + vals[i] * (k + 1 - count[i]));
        }
        return ans;
    }
}