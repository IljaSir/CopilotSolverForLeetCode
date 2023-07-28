class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1];
            if (arr[i] > arr[i-1]) continue;
            dp[i] += arr[i-1] - arr[i] + 1;
            arr[i] = arr[i-1] + 1;
        }
        int ans = dp[n-1];
        for (int i = 1; i < n; i++) {
            if (i >= k) {
                int t = dp[i-1];
                t -= max(0, arr[i-k] - arr[i-1]);
                t += max(0, arr[i-k] - arr[i] + 1);
                ans = min(ans, t);
            }
            if (i + k < n) {
                int t = dp[i-1];
                t -= max(0, arr[i-1] - arr[i+k]);
                t += max(0, arr[i] - arr[i+k] - 1);
                ans = min(ans, t);
            }
        }
        return ans;
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        if (n == 1) return 0;
        int p = 0, q = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) p += arr[i];
            else q += arr[i];
        }
        vector<int> left = {p};
        for (int i = k; i < n; i++) {
            p -= arr[i-k];
            p += arr[i];
            left.push_back(p);
        }
        vector<int> right = {q};
        for (int i = n-1; i >= k; i--) {
            q -= arr[i];
            q += arr[i-k];
            right.push_back(q);
        }
        reverse(right.begin(), right.end());
        vector<int> b(k+1, 0);
        for (int i = 0; i <= k; i++) {
            b[i] = left[i] + right[i];
        }
        sort(b.begin(), b.end());
        return kIncreasing(b, k);
    }
};