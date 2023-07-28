class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        vector<bool> visited(rooms.size(), false);
        int count = 0;
        dfs(rooms, visited, 0, count);
        return count == rooms.size();
    }
    
    void dfs(vector<vector<int>>& rooms, vector<bool>& visited, int room, int& count) {
        if (visited[room]) return;
        visited[room] = true;
        ++count;
        for (int i = 0; i < rooms[room].size(); ++i) {
            dfs(rooms, visited, rooms[room][i], count);
        }
    }
};