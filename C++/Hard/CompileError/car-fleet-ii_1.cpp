class Solution {
public:
    vector<double> getCollisionTimes(vector<vector<int>>& cars) {
        
        int n = cars.size();
        vector<double> ans(n, -1);
        stack<int> s;
        for (int i = n - 1; i >= 0; --i) {
            int p = cars[i][0], s = cars[i][1];
            while (!s.empty()) {
                int j = s.top();
                int p2 = cars[j][0], s2 = cars[j][1];
                if (s2 >= s || (ans[j] >= 0 && (p2 - p) / (s - s2) >= ans[j])) {
                    s.pop();
                } else {
                    break;
                }
            }
            if (!s.empty()) {
                int j = s.top();
                int p2 = cars[j][0], s2 = cars[j][1];
                ans[i] = (double)(p2 - p) / (s - s2);
            }
            s.push(i);
        }
        return ans;
    }
};