class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> dp1(n, 0), dp2(n, 0);
        dp1[0] = arr[0];
        int res = arr[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = max(arr[i], dp1[i - 1] + arr[i]);
            res = max(res, dp1[i]);
        }
        dp2[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = max(arr[i], dp2[i + 1] + arr[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            res = max(res, dp1[i - 1] + dp2[i + 1]);
        }
        return res;
    }
};