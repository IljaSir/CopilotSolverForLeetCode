class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int n = nums.size();
        int l = 1;
        int r = n;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            bool ok = false;
            long long sum = 0;
            for (int i = 0; i < mid; i++) {
                sum += nums[i];
            }
            if (sum > 1LL * mid * threshold) {
                ok = true;
            }
            for (int i = mid; i < n; i++) {
                sum += nums[i];
                sum -= nums[i - mid];
                if (sum > 1LL * mid * threshold) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
};