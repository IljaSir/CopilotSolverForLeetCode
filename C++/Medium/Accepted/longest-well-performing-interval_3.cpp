class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size();
        vector<int> preSum(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        }
        int res = 0;
        stack<int> st;
        for (int i = 0; i <= n; ++i) {
            if (st.empty() || preSum[st.top()] > preSum[i]) {
                st.push(i);
            }
        }
        for (int i = n; i >= 0; --i) {
            while (!st.empty() && preSum[st.top()] < preSum[i]) {
                res = max(res, i - st.top());
                st.pop();
            }
        }
        return res;
    }
};