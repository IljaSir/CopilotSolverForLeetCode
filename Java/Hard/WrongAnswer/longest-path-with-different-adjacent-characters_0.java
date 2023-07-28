class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }
        int[] res = new int[1];
        dfs(graph, s, 0, res);
        return res[0];
    }
    private int[] dfs(List<Integer>[] graph, String s, int node, int[] res) {
        int[] count = new int[26];
        for (int child : graph[node]) {
            int[] childCount = dfs(graph, s, child, res);
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], childCount[i]);
            }
        }
        count[s.charAt(node) - 'a']++;
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, count[i]);
        }
        res[0] = Math.max(res[0], max);
        return count;
    }
}