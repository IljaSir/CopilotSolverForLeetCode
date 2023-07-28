class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int n = nums.size();
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            int sum = 0;
            for (int i = 0; i < m; ++i) {
                sum += nums[i];
            }
            if (sum > threshold) {
                r = m;
                continue;
            }
            for (int i = m; i < n; ++i) {
                sum -= nums[i - m];
                sum += nums[i];
                if (sum > threshold) {
                    r = m;
                    break;
                }
            }
            if (sum <= threshold) {
                l = m + 1;
            }
        }
        return l > n ? -1 : l;
    }
};