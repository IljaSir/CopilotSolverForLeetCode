class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(map, informTime, headID);
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int[] informTime, int headID) {
        int max = 0;
        for (int id : map.getOrDefault(headID, new ArrayList<>())) {
            max = Math.max(max, dfs(map, informTime, id));
        }
        return max + informTime[headID];
    }
}