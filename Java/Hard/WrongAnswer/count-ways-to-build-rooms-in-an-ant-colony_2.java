class Solution {
    public int waysToBuildRooms(int[] prevRoom) {
        
        int n = prevRoom.length;
        int mod = 1000000007;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < n; i++) {
            graph[prevRoom[i]].add(i);
        }
        long[] factorial = new long[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i % mod;
        }
        long[] ways = new long[n];
        Arrays.fill(ways, -1);
        ways[0] = 1;
        return (int) dfs(graph, 0, ways, factorial, mod);
    }
    public long dfs(List<Integer>[] graph, int u, long[] ways, long[] factorial, int mod) {
        if (ways[u] != -1) {
            return ways[u];
        }
        long ans = factorial[graph[u].size()];
        for (int v : graph[u]) {
            ans = ans * dfs(graph, v, ways, factorial, mod) % mod;
        }
        ways[u] = ans;
        return ans;
    }
}