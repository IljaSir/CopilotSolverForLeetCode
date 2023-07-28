class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : -1);
        }
        stack<int> s;
        for (int i = 0; i <= n; ++i) {
            if (s.empty() || sum[s.top()] > sum[i]) {
                s.push(i);
            }
        }
        int res = 0;
        for (int i = n; i >= 0; --i) {
            while (!s.empty() && sum[i] > sum[s.top()]) {
                res = max(res, i - s.top());
                s.pop();
            }
        }
        return res;
    }
};