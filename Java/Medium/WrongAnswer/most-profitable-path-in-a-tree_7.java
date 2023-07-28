class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1, dp, map, amount, bob);
        return dp[bob];
    }
    private void dfs(int node, int parent, int[] dp, Map<Integer, List<Integer>> map, int[] amount, int bob) {
        if (node == bob) {
            return;
        }
        List<Integer> nexts = map.get(node);
        for (int next : nexts) {
            if (next == parent) {
                continue;
            }
            dfs(next, node, dp, map, amount, bob);
            int cost = amount[node];
            if (cost < 0) {
                cost = -cost / 2;
            } else {
                cost /= 2;
            }
            dp[node] = Math.max(dp[node], dp[next] + cost);
        }
    }
}