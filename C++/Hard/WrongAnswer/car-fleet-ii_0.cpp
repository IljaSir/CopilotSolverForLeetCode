class Solution {
public:
    vector<double> getCollisionTimes(vector<vector<int>>& cars) {
        
        int n = cars.size();
        vector<double> res(n, -1);
        stack<int> st;
        for (int i = n - 1; i >= 0; --i) {
            int p = cars[i][0], s = cars[i][1];
            while (!st.empty()) {
                int j = st.top();
                int p2 = cars[j][0], s2 = cars[j][1];
                if ((s2 >= s) || (res[j] > 0 && (p2 - p) / (s - s2) >= res[j])) {
                    st.pop();
                } else {
                    break;
                }
            }
            if (!st.empty()) {
                int j = st.top();
                int p2 = cars[j][0], s2 = cars[j][1];
                res[i] = (p2 - p) / (s - s2);
            }
            st.push(i);
        }
        return res;
    }
};