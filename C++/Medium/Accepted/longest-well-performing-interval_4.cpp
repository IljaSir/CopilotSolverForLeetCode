class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size(), res = 0;
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : -1);
        }
        vector<int> stk = {0};
        for (int i = 1; i <= n; ++i) {
            if (sum[i] < sum[stk.back()]) {
                stk.push_back(i);
            }
        }
        for (int i = n; i > res; --i) {
            while (stk.size() && sum[i] > sum[stk.back()]) {
                res = max(res, i - stk.back());
                stk.pop_back();
            }
        }
        return res;
    }
};