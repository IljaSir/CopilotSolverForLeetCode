class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        int[] res = new int[n];
        boolean[] visited = new boolean[n];
        dfs(map, visited, 0, labels, res);
        return res;
    }

    private int[] dfs(Map<Integer, List<Integer>> map, boolean[] visited, int cur, String labels, int[] res) {
        int[] count = new int[26];
        visited[cur] = true;
        count[labels.charAt(cur) - 'a']++;
        for (int next : map.getOrDefault(cur, new ArrayList<>())) {
            if (!visited[next]) {
                int[] nextCount = dfs(map, visited, next, labels, res);
                for (int i = 0; i < 26; i++) {
                    count[i] += nextCount[i];
                }
            }
        }
        res[cur] = count[labels.charAt(cur) - 'a'];
        return count;
    }
}