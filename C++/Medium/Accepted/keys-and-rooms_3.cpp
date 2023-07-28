class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        int n = rooms.size();
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;
        while (!q.empty()) {
            int room = q.front();
            q.pop();
            for (int key: rooms[room]) {
                if (!visited[key]) {
                    q.push(key);
                    visited[key] = true;
                }
            }
        }
        for (bool v: visited) {
            if (!v) return false;
        }
        return true;
    }
};