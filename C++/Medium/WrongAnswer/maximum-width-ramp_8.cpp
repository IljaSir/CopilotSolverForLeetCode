class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        vector<int> minVal(n, nums[0]);
        for (int i = 1; i < n; ++i) {
            minVal[i] = min(minVal[i - 1], nums[i]);
        }
        for (int i = n - 1; i > ans; --i) {
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (minVal[mid] <= nums[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            ans = max(ans, i - l);
        }
        return ans;
    }
};