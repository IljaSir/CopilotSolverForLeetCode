class Solution {
public:
    bool isEscapePossible(vector<vector<int>>& blocked, vector<int>& source, vector<int>& target) {
        
        unordered_set<int> block;
        for (auto& b : blocked) {
            block.insert(b[0] * 1000000 + b[1]);
        }
        return bfs(block, source, target) && bfs(block, target, source);
    }
    bool bfs(unordered_set<int>& block, vector<int>& source, vector<int>& target) {
        int sx = source[0], sy = source[1], tx = target[0], ty = target[1];
        queue<vector<int>> q;
        q.push({sx, sy});
        unordered_set<int> visited;
        visited.insert(sx * 1000000 + sy);
        int directions[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.empty()) {
            int x = q.front()[0], y = q.front()[1];
            q.pop();
            if (x == tx && y == ty) return true;
            if (visited.size() >= 20000) return true;
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0], ny = y + directions[i][1];
                int key = nx * 1000000 + ny;
                if (nx < 0 || nx >= 1000000 || ny < 0 || ny >= 1000000 || block.count(key) || visited.count(key)) continue;
                q.push({nx, ny});
                visited.insert(key);
            }
        }
        return false;
    }
};