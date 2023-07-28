class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] res = new int[n];
        boolean[] visited = new boolean[n];
        dfs(graph, res, visited, labels, 0);
        return res;
    }
    private int[] dfs(List<Integer>[] graph, int[] res, boolean[] visited, String labels, int node) {
        visited[node] = true;
        int[] count = new int[26];
        count[labels.charAt(node) - 'a']++;
        for (int next : graph[node]) {
            if (!visited[next]) {
                int[] nextCount = dfs(graph, res, visited, labels, next);
                for (int i = 0; i < 26; i++) {
                    count[i] += nextCount[i];
                }
            }
        }
        res[node] = count[labels.charAt(node) - 'a'];
        return count;
    }
}