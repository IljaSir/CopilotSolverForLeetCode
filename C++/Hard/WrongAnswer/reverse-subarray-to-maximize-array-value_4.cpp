class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 1; i < n; i++) {
            res += abs(nums[i] - nums[i - 1]);
        }
        int mx = INT_MIN, mn = INT_MAX;
        for (int i = 1; i < n; i++) {
            mx = max({mx, nums[i] - nums[i - 1], nums[i - 1] - nums[i]});
            mn = min({mn, nums[i] - nums[i - 1], nums[i - 1] - nums[i]});
        }
        for (int i = 1; i < n - 1; i++) {
            int tmp = max(0, abs(nums[i + 1] - nums[0]) - abs(nums[i + 1] - nums[i]));
            tmp = max(tmp, abs(nums[i - 1] - nums[n - 1]) - abs(nums[i - 1] - nums[i]));
            mx = max(mx, tmp);
        }
        return res + mx - mn;
    }
};