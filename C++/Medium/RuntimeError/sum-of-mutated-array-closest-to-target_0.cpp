class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        sort(arr.begin(), arr.end());
        int n = arr.size();
        vector<int> preSum(n);
        preSum[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        int l = 0, r = arr.back();
        int res = 0;
        int diff = INT_MAX;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int idx = upper_bound(arr.begin(), arr.end(), mid) - arr.begin();
            int cur = preSum[idx - 1] + (n - idx) * mid;
            if (cur == target) return mid;
            if (abs(cur - target) < diff) {
                res = mid;
                diff = abs(cur - target);
            } else if (abs(cur - target) == diff) {
                res = min(res, mid);
            }
            if (cur > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
};