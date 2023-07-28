class Solution {
public:
    vector<double> getCollisionTimes(vector<vector<int>>& cars) {
        
        int n = cars.size();
        vector<double> res(n, -1);
        stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && (res[st.top()] == -1 || (cars[st.top()][1] - cars[i][1]) * (cars[i][0] - cars[st.top()][0]) >= (cars[i][1] - cars[st.top()][1]) * (cars[st.top()][0] - cars[st.top()][0]))) {
                st.pop();
            }
            if (!st.empty()) {
                res[i] = 1.0 * (cars[st.top()][0] - cars[i][0]) / (cars[i][1] - cars[st.top()][1]);
            }
            st.push(i);
        }
        return res;
    }
};