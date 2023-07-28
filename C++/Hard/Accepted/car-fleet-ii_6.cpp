class Solution {
public:
    vector<double> getCollisionTimes(vector<vector<int>>& cars) {
        
        int n = cars.size();
        vector<double> ans(n, -1);
        stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            int p = cars[i][0], s = cars[i][1];
            while (!st.empty()) {
                int j = st.top();
                int p2 = cars[j][0], s2 = cars[j][1];
                if (s <= s2 || (ans[j] > 0 && (p2 - p) / (double)(s - s2) >= ans[j])) {
                    st.pop();
                } else {
                    break;
                }
            }
            if (!st.empty()) {
                int j = st.top();
                ans[i] = (cars[j][0] - cars[i][0]) / (double)(cars[i][1] - cars[j][1]);
            }
            st.push(i);
        }
        return ans;
    }
};