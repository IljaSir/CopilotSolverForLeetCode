class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        int n = arr.size();
        sort(arr.begin(), arr.end());
        vector<int> prefix(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        int l = 0, r = arr[n - 1];
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int index = lower_bound(arr.begin(), arr.end(), mid) - arr.begin();
            int sum = prefix[index] + (n - index) * mid;
            if (sum <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int sum1 = check(arr, ans);
        int sum2 = check(arr, ans + 1);
        if (abs(target - sum1) <= abs(target - sum2)) {
            return ans;
        }
        return ans + 1;
    }
};