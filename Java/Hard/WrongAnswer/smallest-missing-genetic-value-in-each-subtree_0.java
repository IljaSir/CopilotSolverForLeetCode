class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        int n = parents.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            graph[parents[i]].add(i);
        }
        int[] res = new int[n];
        boolean[] seen = new boolean[100001];
        for (int i = 0; i < n; i++) {
            seen[nums[i]] = true;
        }
        dfs(graph, 0, nums, seen, res);
        return res;
    }
    
    private int dfs(List<Integer>[] graph, int node, int[] nums, boolean[] seen, int[] res) {
        if (res[node] != 0) {
            return res[node];
        }
        int min = 1;
        for (int i = 1; i <= nums[node]; i++) {
            if (!seen[i]) {
                min = i;
                break;
            }
        }
        res[node] = min;
        seen[nums[node]] = false;
        for (int child : graph[node]) {
            res[child] = dfs(graph, child, nums, seen, res);
        }
        seen[nums[node]] = true;
        return res[node];
    }
}