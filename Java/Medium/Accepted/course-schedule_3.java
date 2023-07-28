class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(map, visited, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int i) {
        if (visited[i] == 1) {
            return true;
        }
        if (visited[i] == 2) {
            return false;
        }
        visited[i] = 1;
        if (map.containsKey(i)) {
            for (int j : map.get(i)) {
                if (dfs(map, visited, j)) {
                    return true;
                }
            }
        }
        visited[i] = 2;
        return false;
    }
}