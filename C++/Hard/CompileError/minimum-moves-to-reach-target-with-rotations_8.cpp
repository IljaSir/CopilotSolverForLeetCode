class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (n == 1)
            return 0;
        queue<pair<pair<int, int>, pair<int, int>>> q;
        q.push({{0, 1}, {0, 0}});
        vector<vector<vector<int>>> visited(n, vector<vector<int>>(n, vector<int>(2, 0)));
        visited[0][0][0] = 1;
        visited[0][1][1] = 1;
        int level = 0;
        while (!q.empty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto p = q.front();
                q.pop();
                int x1 = p.first.first;
                int y1 = p.first.second;
                int x2 = p.second.first;
                int y2 = p.second.second;
                if (x1 == n - 1 && y1 == n - 2)
                    return level - 1;
                if (x2 == n - 1 && y2 == n - 1)
                    return level - 1;
                // move right
                if (y1 + 1 < n && y2 + 1 < n && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0) {
                    int x3 = x1;
                    int y3 = y1 + 1;
                    int x4 = x2;
                    int y4 = y2 + 1;
                    if (visited[x3][y3][0] == 0) {
                        visited[x3][y3][0] = 1;
                        q.push({{x3, y3}, {x4, y4}});
                    }
                }
                // move down
                if (x1 + 1 < n && x2 + 1 < n && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0) {
                    int x3 = x1 + 1;
                    int y3 = y1;
                    int x4 = x2 + 1;
                    int y4 = y2;
                    if (visited[x3][y3][1] == 0) {
                        visited[x3][y3][
    }
};