class Solution {
    public int checkWays(int[][] pairs) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.computeIfAbsent(pair[0], key -> new ArrayList<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], key -> new ArrayList<>()).add(pair[0]);
        }
        int[] res = new int[1];
        dfs(map, 1, new HashSet<>(), res);
        return res[0];
    }

    private int dfs(Map<Integer, List<Integer>> map, int root, Set<Integer> visited, int[] res) {
        if (visited.contains(root)) {
            return 0;
        }
        visited.add(root);
        int children = 0;
        for (int child : map.getOrDefault(root, new ArrayList<>())) {
            children += dfs(map, child, visited, res);
        }
        if (children == 0) {
            res[0]++;
        }
        visited.remove(root);
        return children + 1;
    }
}