class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int[] res = new int[1];
        dfs(0, -1, coins, graph, res);
        return res[0];
    }
    int dfs(int u, int p, int[] coins, List<Integer>[] graph, int[] res) {
        int cnt = coins[u];
        for (int v : graph[u]) {
            if (v == p) continue;
            cnt += dfs(v, u, coins, graph, res);
        }
        res[0] += Math.abs(cnt);
        return cnt;
    }
}