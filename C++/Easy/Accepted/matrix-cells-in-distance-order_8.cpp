class Solution {
public:
    vector<vector<int>> allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        vector<vector<int>> ans;
        queue<pair<int, int>> q;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        q.push(pair<int, int>(rCenter, cCenter));
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int r = p.first;
            int c = p.second;
            if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c]) continue;
            ans.push_back(vector<int>{r, c});
            visited[r][c] = true;
            q.push(pair<int, int>(r - 1, c));
            q.push(pair<int, int>(r + 1, c));
            q.push(pair<int, int>(r, c - 1));
            q.push(pair<int, int>(r, c + 1));
        }
        return ans;
    }
};