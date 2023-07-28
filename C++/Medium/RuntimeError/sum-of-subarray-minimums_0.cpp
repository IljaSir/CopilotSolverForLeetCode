class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> left(n), right(n);
        stack<int> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && arr[s.top()] > arr[i]) s.pop();
            left[i] = s.empty() ? -1 : s.top();
            s.push(i);
        }
        s = stack<int>();
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && arr[s.top()] >= arr[i]) s.pop();
            right[i] = s.empty() ? n : s.top();
            s.push(i);
        }
        int ans = 0, mod = 1e9 + 7;
        for (int i = 0; i < n; ++i) {
            ans = (ans + arr[i] * (i - left[i]) * (right[i] - i)) % mod;
        }
        return ans;
    }
};