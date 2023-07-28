class Solution {
public:
    vector<double> getCollisionTimes(vector<vector<int>>& cars) {
        
        int n = cars.size();
        vector<double> ans(n, -1);
        stack<int> s;
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty()) {
                int j = s.top();
                if (cars[i][1] <= cars[j][1] || (ans[j] > 0 && (cars[j][0] - cars[i][0]) / (double)(cars[i][1] - cars[j][1]) >= ans[j])) {
                    s.pop();
                } else {
                    break;
                }
            }
            if (!s.empty()) {
                int j = s.top();
                ans[i] = (cars[j][0] - cars[i][0]) / (double)(cars[i][1] - cars[j][1]);
            }
            s.push(i);
        }
        return ans;
    }
};