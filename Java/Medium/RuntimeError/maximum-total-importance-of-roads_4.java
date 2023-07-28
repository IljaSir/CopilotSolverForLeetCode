class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] r : roads) {
            graph.computeIfAbsent(r[0], x -> new ArrayList<>()).add(r[1]);
            graph.computeIfAbsent(r[1], x -> new ArrayList<>()).add(r[0]);
        }
        long[] dp = new long[n];
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == 0) {
                dp[i] = dfs(i, graph, dp);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    private long dfs(int i, Map<Integer, List<Integer>> graph, long[] dp) {
        long res = 0;
        for (int j : graph.getOrDefault(i, new ArrayList<>())) {
            if (dp[j] == 0) {
                dp[j] = dfs(j, graph, dp);
            }
            res = Math.max(res, dp[j]);
        }
        return res + i + 1;
    }
}