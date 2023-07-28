class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        int[] ans = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        dfs(graph, 0, -1, ans, count);
        dfs2(graph, 0, -1, ans, count);
        return ans;
    }
    
    private void dfs(List<Integer>[] graph, int root, int parent, int[] ans, int[] count) {
        for (int child : graph[root]) {
            if (child == parent) {
                continue;
            }
            dfs(graph, child, root, ans, count);
            count[root] += count[child];
            ans[root] += ans[child] + count[child];
        }
    }
    
    private void dfs2(List<Integer>[] graph, int root, int parent, int[] ans, int[] count) {
        for (int child : graph[root]) {
            if (child == parent) {
                continue;
            }
            ans[child] = ans[root] - count[child] + count.length - count[child];
            dfs2(graph, child, root, ans, count);
        }
    }
}