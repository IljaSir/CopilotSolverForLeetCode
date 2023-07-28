class Solution {
public:
    int rectangleArea(vector<vector<int>>& rectangles) {
        
        int n = rectangles.size();
        vector<int> x;
        vector<int> y;
        for (auto& r : rectangles) {
            x.push_back(r[0]);
            x.push_back(r[2]);
            y.push_back(r[1]);
            y.push_back(r[3]);
        }
        sort(x.begin(), x.end());
        sort(y.begin(), y.end());
        x.erase(unique(x.begin(), x.end()), x.end());
        y.erase(unique(y.begin(), y.end()), y.end());
        int m = x.size();
        int p = y.size();
        vector<vector<int>> grid(m, vector<int>(p, 0));
        for (auto& r : rectangles) {
            int x1 = lower_bound(x.begin(), x.end(), r[0]) - x.begin();
            int x2 = lower_bound(x.begin(), x.end(), r[2]) - x.begin();
            int y1 = lower_bound(y.begin(), y.end(), r[1]) - y.begin();
            int y2 = lower_bound(y.begin(), y.end(), r[3]) - y.begin();
            for (int i = x1; i < x2; ++i) {
                for (int j = y1; j < y2; ++j) {
                    grid[i][j] = 1;
                }
            }
        }
        long long res = 0;
        for (int i = 0; i < m - 1; ++i) {
            for (int j = 0; j < p - 1; ++j) {
                if (grid[i][j]) {
                    res += 1LL * (x[i + 1] - x[i]) * (y[j + 1] - y[j]);
                }
            }
        }
        return res % 1000000007;
    }
};