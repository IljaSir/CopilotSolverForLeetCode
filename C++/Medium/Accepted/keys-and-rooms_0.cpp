class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        int n = rooms.size();
        vector<int> visited(n, 0);
        dfs(rooms, visited, 0);
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }
    void dfs(vector<vector<int>>& rooms, vector<int>& visited, int room) {
        visited[room] = 1;
        for (int i = 0; i < rooms[room].size(); i++) {
            if (visited[rooms[room][i]] == 0) {
                dfs(rooms, visited, rooms[room][i]);
            }
        }
    }
};