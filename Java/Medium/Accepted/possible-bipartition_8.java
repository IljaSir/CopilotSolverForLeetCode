class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        int[] group = new int[n + 1];
        Arrays.fill(group, -1);
        Map<Integer, Set<Integer>> dislikeMap = new HashMap<>();
        for (int[] dislike : dislikes) {
            dislikeMap.computeIfAbsent(dislike[0], k -> new HashSet<>()).add(dislike[1]);
            dislikeMap.computeIfAbsent(dislike[1], k -> new HashSet<>()).add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (group[i] == -1 && !dfs(dislikeMap, group, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> dislikeMap, int[] group, int i, int g) {
        if (group[i] != -1) {
            return group[i] == g;
        }
        group[i] = g;
        if (!dislikeMap.containsKey(i)) {
            return true;
        }
        for (int j : dislikeMap.get(i)) {
            if (!dfs(dislikeMap, group, j, 1 - g)) {
                return false;
            }
        }
        return true;
    }
}