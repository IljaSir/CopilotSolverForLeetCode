class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> left(n), right(n);
        stack<pair<int, int>> s;
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!s.empty() && s.top().first >= arr[i]) {
                count += s.top().second;
                s.pop();
            }
            s.push({arr[i], count});
            left[i] = count;
        }
        while (!s.empty()) s.pop();
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!s.empty() && s.top().first > arr[i]) {
                count += s.top().second;
                s.pop();
            }
            s.push({arr[i], count});
            right[i] = count;
        }
        int ans = 0, mod = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)arr[i] * left[i] * right[i]) % mod;
        }
        return ans;
    }
};