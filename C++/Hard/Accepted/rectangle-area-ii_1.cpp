class Solution {
public:
    int rectangleArea(vector<vector<int>>& rectangles) {
        
        int n = rectangles.size();
        vector<int> x, y;
        for (auto& r : rectangles) {
            x.push_back(r[0]);
            x.push_back(r[2]);
            y.push_back(r[1]);
            y.push_back(r[3]);
        }
        sort(x.begin(), x.end());
        x.erase(unique(x.begin(), x.end()), x.end());
        sort(y.begin(), y.end());
        y.erase(unique(y.begin(), y.end()), y.end());
        vector<vector<int>> grid(x.size(), vector<int>(y.size()));
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
        long long ans = 0;
        for (int i = 0; i < x.size(); ++i) {
            for (int j = 0; j < y.size(); ++j) {
                if (grid[i][j]) {
                    ans += (long long)(x[i + 1] - x[i]) * (y[j + 1] - y[j]);
                }
            }
        }
        return ans % 1000000007;
    }
};