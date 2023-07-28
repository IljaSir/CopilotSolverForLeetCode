class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (!map.containsKey(manager[i])) {
                map.put(manager[i], new ArrayList<>());
            }
            map.get(manager[i]).add(i);
        }
        return dfs(map, headID, informTime);
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int id, int[] informTime) {
        if (!map.containsKey(id)) {
            return 0;
        }
        int max = 0;
        for (int sub : map.get(id)) {
            max = Math.max(max, dfs(map, sub, informTime));
        }
        return max + informTime[id];
    }
}