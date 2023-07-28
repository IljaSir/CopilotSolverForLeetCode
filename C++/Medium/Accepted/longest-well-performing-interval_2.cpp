class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size();
        vector<int> preSum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            preSum[i + 1] = preSum[i] + (hours[i] > 8 ? 1 : -1);
        }
        int res = 0;
        stack<int> stk;
        for (int i = 0; i < n + 1; ++i) {
            if (stk.empty() || preSum[stk.top()] > preSum[i]) {
                stk.push(i);
            }
        }
        for (int i = n; i >= 0; --i) {
            while (!stk.empty() && preSum[stk.top()] < preSum[i]) {
                res = max(res, i - stk.top());
                stk.pop();
            }
        }
        return res;
    }
};