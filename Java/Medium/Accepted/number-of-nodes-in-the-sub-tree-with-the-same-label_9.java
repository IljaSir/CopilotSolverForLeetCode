class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        int[] result = new int[n];
        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        // dfs
        dfs(graph, labels, result, new boolean[n], 0);
        return result;
    }

    private int[] dfs(Map<Integer, List<Integer>> graph, String labels, int[] result, boolean[] visited, int node) {
        int[] count = new int[26];
        visited[node] = true;
        for (int child : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited[child]) {
                int[] childCount = dfs(graph, labels, result, visited, child);
                for (int i = 0; i < 26; i++) {
                    count[i] += childCount[i];
                }
            }
        }
        count[labels.charAt(node) - 'a']++;
        result[node] = count[labels.charAt(node) - 'a'];
        return count;
    }
}