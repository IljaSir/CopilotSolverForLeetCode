class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] depth = new int[n];
        int[] parent = new int[n];
        int[][] ancestor = new int[n][51];
        dfs(0, -1, 0, nums, adj, depth, parent, ancestor);
        for (int i = 0; i < n; i++) {
            int u = i;
            for (int d = 50; d >= 2; d--) {
                if (ancestor[u][d] != 0) {
                    if (gcd(nums[i], d) == 1) {
                        ans[i] = ancestor[u][d];
                        break;
                    }
                    u = ancestor[u][d];
                }
            }
        }
        return ans;
    }
    private void dfs(int u, int p, int d, int[] nums, List<Integer>[] adj, int[] depth, int[] parent, int[][] ancestor) {
        depth[u] = d;
        parent[u] = p;
        ancestor[u][nums[u]] = p;
        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, d + 1, nums, adj, depth, parent, ancestor);
            }
        }
    }
}