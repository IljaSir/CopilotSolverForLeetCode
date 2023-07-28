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
        int[] sum = new int[n];
        int[] size = new int[n];
        int[] max = new int[n];
        int[] max2 = new int[n];

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dfs(i, -1, graph, dp, sum, size, max, max2);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private void dfs(int cur, int pre, List<Integer>[] graph, int[] dp, int[] sum, int[] size, int[] max, int[] max2) {
        sum[cur] = max[cur] = max2[cur] = 0;
        size[cur] = 1;
        for (int nxt : graph[cur]) {
            if (nxt != pre) {
                dfs(nxt, cur, graph, dp, sum, size, max, max2);
                sum[cur] += sum[nxt];
                size[cur] += size[nxt];
                if (max[nxt] > max[cur]) {
                    max2[cur] = max[cur];
                    max[cur] = max[nxt];
                } else if (max[nxt] > max2[cur]) {
                    max2[cur] = max[nxt];
                }
            }
        }
        sum[cur] += max[cur];
        dp[cur] = sum[cur];
        if (size[cur] > 1) {
            dp[cur] = Math.max(dp[cur], sum[cur] + max2[cur]);
        }
    }
}