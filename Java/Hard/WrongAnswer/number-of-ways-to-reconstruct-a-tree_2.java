class Solution {
    public int checkWays(int[][] pairs) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int[] visited = new int[501];
        int res = 0;
        for (int i = 1; i <= 500; i++) {
            if (visited[i] == 0 && map.containsKey(i)) {
                int[] count = new int[1];
                count[0] = 0;
                dfs(map, i, visited, count);
                res += count[0];
            }
        }
        return res > 1 ? 2 : res;
    }
    private void dfs(HashMap<Integer, List<Integer>> map, int cur, int[] visited, int[] count) {
        visited[cur] = 1;
        count[0]++;
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (visited[next] == 0) {
                    dfs(map, next, visited, count);
                }
            }
        }
    }
}