class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> left(n, -1), right(n, n);
        stack<int> s1, s2;
        for (int i = 0; i < n; i++) {
            while (!s1.empty() && arr[s1.top()] > arr[i]) {
                s1.pop();
            }
            left[i] = s1.empty() ? -1 : s1.top();
            s1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.empty() && arr[s2.top()] >= arr[i]) {
                s2.pop();
            }
            right[i] = s2.empty() ? n : s2.top();
            s2.push(i);
        }
        int ans = 0, mod = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans = (ans + arr[i] * (i - left[i]) * (right[i] - i)) % mod;
        }
        return ans;
    }
};