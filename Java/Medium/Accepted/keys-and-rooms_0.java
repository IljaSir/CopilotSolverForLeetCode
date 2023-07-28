class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        visited[i] = true;
        for (int j : rooms.get(i)) {
            if (!visited[j]) {
                dfs(rooms, visited, j);
            }
        }
    }
}