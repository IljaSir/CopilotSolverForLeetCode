class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        int[] res = new int[n];
        dfs(graph, 0, new HashSet<>(), labels, res);
        return res;
    }
    int[] dfs(Map<Integer, Set<Integer>> graph, int cur, Set<Integer> visited, String labels, int[] res) {
        int[] cnt = new int[26];
        visited.add(cur);
        for (int next : graph.getOrDefault(cur, new HashSet<>())) {
            if (!visited.contains(next)) {
                int[] nextCnt = dfs(graph, next, visited, labels, res);
                for (int i = 0; i < 26; i++) {
                    cnt[i] += nextCnt[i];
                }
            }
        }
        cnt[labels.charAt(cur) - 'a']++;
        res[cur] = cnt[labels.charAt(cur) - 'a'];
        return cnt;
    }
}