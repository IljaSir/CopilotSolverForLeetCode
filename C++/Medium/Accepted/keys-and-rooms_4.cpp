class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        vector<bool> visited(rooms.size(), false);
        dfs(rooms, visited, 0);
        for (bool v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    
    void dfs(vector<vector<int>>& rooms, vector<bool>& visited, int i) {
        visited[i] = true;
        for (int k : rooms[i]) {
            if (!visited[k]) {
                dfs(rooms, visited, k);
            }
        }
    }
};