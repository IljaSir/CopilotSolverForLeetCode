class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        int[] res = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e: edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        dfs(graph, labels, res, new boolean[n], 0);
        return res;
    }
    private int[] dfs(List<Integer>[] graph, String labels, int[] res, boolean[] visited, int cur) {
        int[] count = new int[26];
        visited[cur] = true;
        for (int next: graph[cur]) {
            if (!visited[next]) {
                int[] nextCount = dfs(graph, labels, res, visited, next);
                for (int i = 0; i < 26; i++) count[i] += nextCount[i];
            }
        }
        count[labels.charAt(cur) - 'a']++;
        res[cur] = count[labels.charAt(cur) - 'a'];
        return count;
    }
}