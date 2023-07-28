class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal == 0) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        int[] visited = new int[maxChoosableInteger + 1];
        Map<Integer, Boolean> map = new HashMap<>();
        return dfs(visited, desiredTotal, map);
    }

    private boolean dfs(int[] visited, int desiredTotal, Map<Integer, Boolean> map) {
        if (desiredTotal <= 0) {
            return false;
        }
        int key = format(visited);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (!dfs(visited, desiredTotal - i, map)) {
                    visited[i] = 0;
                    map.put(key, true);
                    return true;
                }
                visited[i] = 0;
            }
        }
        map.put(key, false);
        return false;
    }

    private int format(int[] visited) {
        int num = 0;
        for (int i = 0; i < visited.length; i++) {
            num |= visited[i] << i;
        }
        return num;
    }
}