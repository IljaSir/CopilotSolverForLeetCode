class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            map.computeIfAbsent(roads[i][0], x -> new ArrayList<>()).add(roads[i][1]);
            map.computeIfAbsent(roads[i][1], x -> new ArrayList<>()).add(roads[i][0]);
        }
        long[] max = new long[n];
        Arrays.fill(max, 1);
        for (int i = 0; i < n; i++) {
            if (max[i] == 1) {
                dfs(i, map, max);
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += max[i];
        }
        return res;
    }
    private long dfs(int i, Map<Integer, List<Integer>> map, long[] max) {
        if (max[i] != 1) {
            return max[i];
        }
        long res = 1;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                res += dfs(j, map, max);
            }
        }
        max[i] = res;
        return res;
    }
}