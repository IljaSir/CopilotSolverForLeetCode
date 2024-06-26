class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        int n = rooms.size();
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            for (int key : rooms[cur]) {
                if (!visited[key]) {
                    visited[key] = true;
                    q.push(key);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
};