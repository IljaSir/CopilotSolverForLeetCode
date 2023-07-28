class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        int[] ans = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(graph, labels, 0, -1, ans, new int[26]);
        return ans;
    }
    
    private void dfs(List<Integer>[] graph, String labels, int cur, int parent, int[] ans, int[] count) {
        count[labels.charAt(cur) - 'a']++;
        for (int child : graph[cur]) {
            if (child != parent) {
                dfs(graph, labels, child, cur, ans, count);
            }
        }
        ans[cur] = count[labels.charAt(cur) - 'a'];
    }
}