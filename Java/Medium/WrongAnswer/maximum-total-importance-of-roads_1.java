class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
            map.computeIfAbsent(road[1], k -> new ArrayList<>()).add(road[0]);
        }
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = i + 1;
        }
        long[] sum = new long[n];
        boolean[] visited = new boolean[n];
        dfs(map, value, sum, visited, 0);
        return Arrays.stream(sum).max().getAsLong();
    }
    
    private void dfs(Map<Integer, List<Integer>> map, int[] value, long[] sum, boolean[] visited, int cur) {
        visited[cur] = true;
        for (int next : map.getOrDefault(cur, Collections.emptyList())) {
            if (!visited[next]) {
                sum[next] = sum[cur] + value[next];
                dfs(map, value, sum, visited, next);
            }
        }
    }
}