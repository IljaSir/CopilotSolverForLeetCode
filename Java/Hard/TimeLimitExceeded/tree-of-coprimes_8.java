class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] ans = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        int[] depth = new int[n];
        int[][] parent = new int[n][51];
        dfs(graph, 0, -1, 0, nums, depth, parent);
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int d = depth[i];
            for (int j = 1; j <= 50; j++) {
                if (cur % j == 0) {
                    while (parent[i][j] != -1 && depth[parent[i][j]] >= d) {
                        i = parent[i][j];
                    }
                }
            }
            ans[i] = parent[i][cur];
        }
        return ans;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node, int par, int d, int[] nums, int[] depth, int[][] parent) {
        parent[node][nums[node]] = par;
        depth[node] = d;
        for (int nei : graph.getOrDefault(node, new ArrayList<>())) {
            if (nei != par) {
                dfs(graph, nei, node, d + 1, nums, depth, parent);
            }
        }
    }
}