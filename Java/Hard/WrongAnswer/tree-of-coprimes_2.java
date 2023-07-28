class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[][] graph = new int[n][];
        int[] deg = new int[n];
        for (int[] e : edges) {
            deg[e[0]]++;
            deg[e[1]]++;
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new int[deg[i]];
        }
        for (int[] e : edges) {
            graph[e[0]][--deg[e[0]]] = e[1];
            graph[e[1]][--deg[e[1]]] = e[0];
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        dfs(nums, graph, 0, -1, new int[51], ans);
        return ans;
    }

    private void dfs(int[] nums, int[][] graph, int u, int p, int[] depth, int[] ans) {
        int d = depth[nums[u]];
        depth[nums[u]] = u;
        for (int v : graph[u]) {
            if (v != p) {
                dfs(nums, graph, v, u, depth, ans);
            }
        }
        int best = -1;
        for (int i = 1; i <= 50; i++) {
            if (i != nums[u] && depth[i] != 0 && (best == -1 || depth[i] > depth[best])) {
                best = i;
            }
        }
        ans[u] = best == -1 ? -1 : depth[best];
        depth[nums[u]] = d;
    }
}