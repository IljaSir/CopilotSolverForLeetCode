class Solution {
public:
    int rectangleArea(vector<vector<int>>& rectangles) {
        
        int MOD = 1000000007;
        set<int> X, Y;
        for (auto& rec: rectangles) {
            X.insert(rec[0]);
            X.insert(rec[2]);
            Y.insert(rec[1]);
            Y.insert(rec[3]);
        }
        vector<int> x;
        vector<int> y;
        for (int i: X) x.push_back(i);
        for (int j: Y) y.push_back(j);
        vector<vector<int>> count(x.size(), vector<int>(y.size()));
        for (auto& rec: rectangles) {
            int x1 = rec[0], y1 = rec[1], x2 = rec[2], y2 = rec[3];
            int x1i = lower_bound(x.begin(), x.end(), x1) - x.begin();
            int x2i = lower_bound(x.begin(), x.end(), x2) - x.begin();
            int y1i = lower_bound(y.begin(), y.end(), y1) - y.begin();
            int y2i = lower_bound(y.begin(), y.end(), y2) - y.begin();
            for (int i = x1i; i < x2i; i++) {
                for (int j = y1i; j < y2i; j++) {
                    count[i][j]++;
                }
            }
        }
        long long ans = 0;
        for (int i = 0; i < x.size() - 1; i++) {
            for (int j = 0; j < y.size() - 1; j++) {
                if (count[i][j]) {
                    ans += (long long)(x[i + 1] - x[i]) * (y[j + 1] - y[j]);
                    ans %= MOD;
                }
            }
        }
        return ans;
    }
};