class Solution {
public:
    int movesToMakeZigzag(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return 0;
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < n; i += 2) {
            int l = i == 0 ? 1001 : nums[i - 1];
            int r = i == n - 1 ? 1001 : nums[i + 1];
            int m = min(l, r);
            if (nums[i] >= m) ans1 += nums[i] - m + 1;
        }
        for (int i = 1; i < n; i += 2) {
            int l = i == 0 ? 1001 : nums[i - 1];
            int r = i == n - 1 ? 1001 : nums[i + 1];
            int m = min(l, r);
            if (nums[i] >= m) ans2 += nums[i] - m + 1;
        }
        return min(ans1, ans2);
    }
};