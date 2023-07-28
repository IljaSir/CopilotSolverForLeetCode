class Solution {
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        
        vector<vector<int>> ans;
        bool flag[8][8];
        memset(flag, 0, sizeof(flag));
        for (auto& v : queens) {
            flag[v[0]][v[1]] = true;
        }
        vector<int> dx = {0, 0, 1, -1, 1, -1, 1, -1};
        vector<int> dy = {1, -1, 0, 0, 1, -1, -1, 1};
        for (int i = 0; i < 8; i++) {
            int x = king[0] + dx[i];
            int y = king[1] + dy[i];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (flag[x][y]) {
                    ans.push_back({x, y});
                    break;
                }
                x += dx[i];
                y += dy[i];
            }
        }
        return ans;
    }
};