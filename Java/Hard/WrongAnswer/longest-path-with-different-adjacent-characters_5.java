class Solution {
    public int longestPath(int[] parent, String s) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = parent.length;
        for (int i = 0; i < n; i++) {
            int p = parent[i];
            if (p != -1) {
                Set<Integer> set = map.getOrDefault(p, new HashSet<>());
                set.add(i);
                map.put(p, set);
            }
        }
        return dfs(map, s, 0, ' ');
    }
    private int dfs(Map<Integer, Set<Integer>> map, String s, int i, char c) {
        int res = 0;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (s.charAt(j) != c) {
                    res = Math.max(res, 1 + dfs(map, s, j, s.charAt(j)));
                } else {
                    res = Math.max(res, dfs(map, s, j, c));
                }
            }
        }
        return res;
    }
}