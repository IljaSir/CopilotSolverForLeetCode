class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        vector<bool> visited(rooms.size(), false);
        dfs(rooms, 0, visited);
        for (auto v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    void dfs(vector<vector<int>>& rooms, int i, vector<bool>& visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (auto j : rooms[i]) {
            dfs(rooms, j, visited);
        }
    }
};