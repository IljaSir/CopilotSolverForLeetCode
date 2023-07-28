class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> left(n, -1);
        vector<int> right(n, n);
        stack<pair<int, int>> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && s.top().first > arr[i]) {
                right[s.top().second] = i;
                s.pop();
            }
            if (!s.empty()) {
                left[i] = s.top().second;
            }
            s.push({arr[i], i});
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + (i - left[i]) * (right[i] - i) % 1000000007 * arr[i]) % 1000000007;
        }
        return ans;
    }
};