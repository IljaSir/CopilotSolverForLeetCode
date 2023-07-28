class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i], list);
        }
        return dfs(map, headID, informTime);
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int cur, int[] informTime) {
        if (!map.containsKey(cur)) return 0;
        int max = 0;
        for (int next : map.get(cur)) {
            max = Math.max(max, dfs(map, next, informTime));
        }
        return max + informTime[cur];
    }
}