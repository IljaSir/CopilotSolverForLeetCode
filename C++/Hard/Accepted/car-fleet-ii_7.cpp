class Solution {
public:
    vector<double> getCollisionTimes(vector<vector<int>>& cars) {
        
        int n = cars.size();
        vector<double> ans(n, -1);
        stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && (cars[i][1] <= cars[st.top()][1] || (ans[st.top()] > 0 && (cars[st.top()][0] - cars[i][0]) / (double)(cars[i][1] - cars[st.top()][1]) >= ans[st.top()]))) {
                st.pop();
            }
            if (!st.empty()) {
                ans[i] = (cars[st.top()][0] - cars[i][0]) / (double)(cars[i][1] - cars[st.top()][1]);
            }
            st.push(i);
        }
        return ans;
    }
};