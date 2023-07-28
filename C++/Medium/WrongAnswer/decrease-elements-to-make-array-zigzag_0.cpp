class Solution {
public:
    int movesToMakeZigzag(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return 0;
        int res1 = 0, res2 = 0;
        for (int i = 0; i < n; i++) {
            int l = i > 0 ? nums[i - 1] : INT_MAX;
            int r = i < n - 1 ? nums[i + 1] : INT_MAX;
            int minVal = min(l, r);
            if (minVal <= nums[i]) {
                res1 += nums[i] - minVal + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            int l = i > 0 ? nums[i - 1] : INT_MAX;
            int r = i < n - 1 ? nums[i + 1] : INT_MAX;
            int minVal = min(l, r);
            if (minVal <= nums[i]) {
                res2 += nums[i] - minVal + 1;
            }
        }
        return min(res1, res2);
    }
};