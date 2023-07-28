class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road: roads) {
            int u = road[0];
            int v = road[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] size = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        dfs(0, adj, size, parent);
        long ans = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i < n; i++) {
            set.add(size[i]);
        }
        while (set.size() > seats) {
            int v = set.pollFirst();
            ans += v;
            int u = parent[v];
            set.remove(size[u]);
            size[u] += size[v];
            set.add(size[u]);
        }
        return ans;
    }
    private void dfs(int v, List<List<Integer>> adj, int[] size, int[] parent) {
        size[v] = 1;
        for (int u: adj.get(v)) {
            if (u != parent[v]) {
                parent[u] = v;
                dfs(u, adj, size, parent);
                size[v] += size[u];
            }
        }
    }
}