class Solution {
public:
    bool isEscapePossible(vector<vector<int>>& blocked, vector<int>& source, vector<int>& target) {
        
        unordered_set<int> block;
        for (auto& b: blocked) {
            block.insert(b[0] * 1000000 + b[1]);
        }
        return bfs(block, source, target) && bfs(block, target, source);
    }
    
    bool bfs(unordered_set<int>& block, vector<int>& source, vector<int>& target) {
        queue<vector<int>> q;
        q.push(source);
        unordered_set<int> visited;
        visited.insert(source[0] * 1000000 + source[1]);
        int cnt = 0;
        while (!q.empty()) {
            auto cur = q.front();
            q.pop();
            ++cnt;
            if (cur[0] == target[0] && cur[1] == target[1]) return true;
            if (cnt >= 20000) return true;
            for (auto& d: dirs) {
                int nx = cur[0] + d[0], ny = cur[1] + d[1];
                if (nx < 0 || nx >= 1000000 || ny < 0 || ny >= 1000000 || block.count(nx * 1000000 + ny) || visited.count(nx * 1000000 + ny)) continue;
                visited.insert(nx * 1000000 + ny);
                q.push({nx, ny});
            }
        }
        return false;
    }
};