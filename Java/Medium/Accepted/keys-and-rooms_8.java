class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
        visit(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    void visit(List<List<Integer>> rooms, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j : rooms.get(i)) {
            visit(rooms, j, visited);
        }
    }
}