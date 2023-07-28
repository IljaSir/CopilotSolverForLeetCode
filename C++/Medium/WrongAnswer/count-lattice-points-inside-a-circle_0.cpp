class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        int n = circles.size();
        vector<int> x(n), y(n), r(n);
        for (int i = 0; i < n; i++) {
            x[i] = circles[i][0];
            y[i] = circles[i][1];
            r[i] = circles[i][2];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d2 = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                int r2 = (r[i] + r[j]) * (r[i] + r[j]);
                if (d2 <= r2) {
                    if (d2 + r[j] * r[j] <= r[i] * r[i]) {
                        ans += 4 * r[i];
                    } else if (d2 + r[i] * r[i] <= r[j] * r[j]) {
                        ans += 4 * r[j];
                    } else {
                        ans += 4 * (r[i] + r[j]);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int r2 = r[i] * r[i];
            int cnt = 0;
            for (int j = 0; j <= r[i]; j++) {
                int k = sqrt(r2 - j * j);
                cnt += 4 * k;
            }
            ans += cnt;
        }
        return ans;
    }
};