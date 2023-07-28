class Solution {
public:
    bool isEscapePossible(vector<vector<int>>& blocked, vector<int>& source, vector<int>& target) {
        
        unordered_set<int> blockedSet;
        for (auto& b : blocked) {
            blockedSet.insert(b[0] * 1000000 + b[1]);
        }
        return bfs(blockedSet, source, target) && bfs(blockedSet, target, source);
    }
    
    bool bfs(unordered_set<int>& blockedSet, vector<int>& source, vector<int>& target) {
        int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue<pair<int, int>> q;
        unordered_set<int> visited;
        q.push({source[0], source[1]});
        visited.insert(source[0] * 1000000 + source[1]);
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto cur = q.front();
                q.pop();
                if (cur.first == target[0] && cur.second == target[1]) return true;
                for (int j = 0; j < 4; j++) {
                    int x = cur.first + dir[j][0];
                    int y = cur.second + dir[j][1];
                    int key = x * 1000000 + y;
                    if (x < 0 || x >= 1000000 || y < 0 || y >= 1000000 || blockedSet.count(key) || visited.count(key)) continue;
                    visited.insert(key);
                    q.push({x, y});
                }
            }
            if (visited.size() >= 20000) return true;
        }
        return false;
    }
};