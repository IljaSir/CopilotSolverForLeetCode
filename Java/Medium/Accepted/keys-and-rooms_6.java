class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, visited, 0);
        for (int i=0; i<rooms.size(); i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        for (int j: rooms.get(i)) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            dfs(rooms, visited, j);
        }
    }
}