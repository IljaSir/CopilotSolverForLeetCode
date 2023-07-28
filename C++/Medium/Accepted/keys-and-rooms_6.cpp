class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        int n = rooms.size();
        vector<bool> visited(n, false);
        dfs(rooms, visited, 0);
        for (bool v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    
    void dfs(vector<vector<int>>& rooms, vector<bool>& visited, int cur) {
        visited[cur] = true;
        for (int next : rooms[cur]) {
            if (!visited[next]) {
                dfs(rooms, visited, next);
            }
        }
    }
};