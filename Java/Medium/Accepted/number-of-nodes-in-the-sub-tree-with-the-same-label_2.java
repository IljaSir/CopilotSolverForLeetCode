class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int[] res = new int[n];
        dfs(0, new HashSet<>(), map, labels, res);
        return res;
    }
    private int[] dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> map, String labels, int[] res) {
        int[] count = new int[26];
        visited.add(node);
        for (int next : map.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(next)) {
                int[] nextCount = dfs(next, visited, map, labels, res);
                for (int i = 0; i < 26; i++) {
                    count[i] += nextCount[i];
                }
            }
        }
        count[labels.charAt(node) - 'a']++;
        res[node] = count[labels.charAt(node) - 'a'];
        return count;
    }
}