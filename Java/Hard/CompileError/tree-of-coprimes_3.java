class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dfs(0, -1, nums, g, ans, new int[51], new int[51]);
        return ans;
    }
    
    void dfs(int u, int p, int[] nums, List<Integer>[] g, int[] ans, int[] depth, int[] parent) {
        int d = depth[nums[u]];
        int par = parent[nums[u]];
        depth[nums[u]] = 0;
        parent[nums[u]] = u;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u, nums, g, ans, depth, parent);
            }
        }
        ans[u] = depth[nums[u]] == 0 ? -1 : parent[nums[u]];
        depth[nums[u]] = d;
        parent[nums[u]] = par;
        for (int i = 1; i <= 50; i++) {
            if (gcd(nums[u], i) == 1) {
                if (depth[i] > depth[nums[u]]) {
                    depth[nums[u]] = depth[i];
                    parent[nums[u]] = parent[i];
                }
            }
        }
        depth[nums[u]]++;
    }
}