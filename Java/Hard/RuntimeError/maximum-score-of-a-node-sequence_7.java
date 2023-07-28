class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, i, scores, graph, dp));
        }
        return max;
    }
    
    private int dfs(int start, int cur, int[] scores, Map<Integer, List<Integer>> graph, int[] dp) {
        if (dp[cur] != -1) {
            return dp[cur];
        }
        int res = scores[cur];
        for (int next : graph.getOrDefault(cur, Collections.emptyList())) {
            if (next == start) {
                continue;
            }
            res = Math.max(res, dfs(start, next, scores, graph, dp) + scores[cur]);
        }
        dp[cur] = res;
        return res;
    }
}