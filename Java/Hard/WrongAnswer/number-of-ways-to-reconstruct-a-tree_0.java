class Solution {
    public int checkWays(int[][] pairs) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int[] count = new int[1];
        int[] root = new int[1];
        boolean[] visited = new boolean[501];
        dfs(map, 1, visited, count, root);
        if (count[0] != pairs.length + 1) {
            return 0;
        }
        return root[0] == 1 ? 1 : 2;
    }
    
    private void dfs(Map<Integer, List<Integer>> map, int node, boolean[] visited, int[] count, int[] root) {
        visited[node] = true;
        count[0]++;
        for (int next : map.getOrDefault(node, new ArrayList<>())) {
            if (visited[next]) {
                continue;
            }
            dfs(map, next, visited, count, root);
            root[0]++;
        }
    }
}