class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        vector<long long> left(n), right(n);
        stack<int> stk;
        for (int i = 0; i < n; ++i) {
            while (!stk.empty() && strength[stk.top()] >= strength[i]) {
                stk.pop();
            }
            left[i] = stk.empty() ? -1 : stk.top();
            stk.push(i);
        }
        while (!stk.empty()) {
            stk.pop();
        }
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.empty() && strength[stk.top()] > strength[i]) {
                stk.pop();
            }
            right[i] = stk.empty() ? n : stk.top();
            stk.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (long long)strength[i] * (i - left[i]) * (right[i] - i);
            ans %= 1000000007;
        }
        return ans;
    }
};