class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        
        int m = isWater.size();
        int n = isWater[0].size();
        vector<vector<int>> res(m, vector<int>(n, -1));
        queue<pair<int, int>> q;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    q.push(make_pair(i, j));
                    res[i][j] = 0;
                }
            }
        }
        int step = 0;
        while(!q.empty()) {
            int size = q.size();
            step++;
            while(size--) {
                auto p = q.front();
                q.pop();
                int x = p.first;
                int y = p.second;
                if(x > 0 && res[x - 1][y] == -1) {
                    res[x - 1][y] = step;
                    q.push(make_pair(x - 1, y));
                }
                if(x < m - 1 && res[x + 1][y] == -1) {
                    res[x + 1][y] = step;
                    q.push(make_pair(x + 1, y));
                }
                if(y > 0 && res[x][y - 1] == -1) {
                    res[x][y - 1] = step;
                    q.push(make_pair(x, y - 1));
                }
                if(y < n - 1 && res[x][y + 1] == -1) {
                    res[x][y + 1] = step;
                    q.push(make_pair(x, y + 1));
                }
            }
        }
        return res;
    }
};