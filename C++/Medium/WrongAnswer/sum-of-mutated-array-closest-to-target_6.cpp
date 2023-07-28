class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        int n = arr.size();
        sort(arr.begin(), arr.end());
        vector<int> pre(n+1);
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + arr[i];
        }
        int l = 0, r = arr[n-1];
        int res = 0, diff = INT_MAX;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int idx = lower_bound(arr.begin(), arr.end(), mid) - arr.begin();
            int sum = pre[idx] + (n - idx) * mid;
            if (sum <= target) {
                if (target - sum < diff) {
                    diff = target - sum;
                    res = mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
};