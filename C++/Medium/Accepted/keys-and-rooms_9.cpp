class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        int n = rooms.size();
        if (n<=1) return true;
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;
        while (!q.empty()) {
            int top = q.front();
            q.pop();
            for (int i=0; i<rooms[top].size(); i++) {
                if (!visited[rooms[top][i]]) {
                    q.push(rooms[top][i]);
                    visited[rooms[top][i]] = true;
                }
            }
        }
        for (int i=0; i<n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
};