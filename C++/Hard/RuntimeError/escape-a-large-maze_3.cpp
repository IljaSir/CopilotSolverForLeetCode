class Solution {
public:
    bool isEscapePossible(vector<vector<int>>& blocked, vector<int>& source, vector<int>& target) {
        
        unordered_set<int> block;
        for (auto& p : blocked) {
            block.insert(p[0] * 1000000 + p[1]);
        }
        return bfs(block, source, target) && bfs(block, target, source);
    }
    
    bool bfs(unordered_set<int>& block, vector<int>& source, vector<int>& target) {
        int m = 1000000;
        queue<vector<int>> q;
        q.push(source);
        unordered_set<int> visited;
        visited.insert(source[0] * m + source[1]);
        int cnt = 0;
        while (!q.empty()) {
            vector<int> p = q.front(); q.pop();
            cnt++;
            if (cnt > 20000) return true;
            if (p[0] == target[0] && p[1] == target[1]) return true;
            int dirs[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int i = 0; i < 4; i++) {
                int x = p[0] + dirs[i][0];
                int y = p[1] + dirs[i][1];
                if (x < 0 || x >= m || y < 0 || y >= m) continue;
                if (visited.count(x * m + y)) continue;
                if (block.count(x * m + y)) continue;
                visited.insert(x * m + y);
                q.push({x, y});
            }
        }
        return false;
    }
};