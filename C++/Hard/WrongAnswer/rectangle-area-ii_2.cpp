class Solution {
public:
    int rectangleArea(vector<vector<int>>& rectangles) {
        
        int n = rectangles.size();
        vector<int> xs;
        for (auto& rec : rectangles) {
            xs.push_back(rec[0]);
            xs.push_back(rec[2]);
        }
        sort(xs.begin(), xs.end());
        xs.erase(unique(xs.begin(), xs.end()), xs.end());
        vector<int> ys;
        for (auto& rec : rectangles) {
            ys.push_back(rec[1]);
            ys.push_back(rec[3]);
        }
        sort(ys.begin(), ys.end());
        ys.erase(unique(ys.begin(), ys.end()), ys.end());
        vector<vector<int>> g(xs.size() - 1, vector<int>(ys.size() - 1));
        for (auto& rec : rectangles) {
            int x1 = lower_bound(xs.begin(), xs.end(), rec[0]) - xs.begin();
            int x2 = lower_bound(xs.begin(), xs.end(), rec[2]) - xs.begin();
            int y1 = lower_bound(ys.begin(), ys.end(), rec[1]) - ys.begin();
            int y2 = lower_bound(ys.begin(), ys.end(), rec[3]) - ys.begin();
            for (int i = x1; i < x2; ++i) {
                for (int j = y1; j < y2; ++j) {
                    g[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < xs.size() - 1; ++i) {
            for (int j = 0; j < ys.size() - 1; ++j) {
                if (g[i][j]) {
                    ans += (long long)(xs[i + 1] - xs[i]) * (ys[j + 1] - ys[j]);
                    ans %= 1000000007;
                }
            }
        }
        return ans;
    }
};