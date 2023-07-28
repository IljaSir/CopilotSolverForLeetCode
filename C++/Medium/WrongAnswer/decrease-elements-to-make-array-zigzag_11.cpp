class Solution {
public:
    int movesToMakeZigzag(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return 0;
        int res1 = 0, res2 = 0;
        for (int i = 0; i < n; i++) {
            int l = i - 1 >= 0 ? nums[i - 1] : INT_MAX;
            int r = i + 1 < n ? nums[i + 1] : INT_MAX;
            int m = min(l, r);
            if (i % 2 == 0) {
                if (nums[i] >= m) res1 += nums[i] - m + 1;
            } else {
                if (nums[i] <= m) res2 += m - nums[i] + 1;
            }
        }
        return min(res1, res2);
    }
};