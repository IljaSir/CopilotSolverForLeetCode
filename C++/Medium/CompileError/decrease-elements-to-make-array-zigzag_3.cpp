class Solution {
public:
    int movesToMakeZigzag(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return 0;
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < n; i += 2) {
            int a = 0, b = 0;
            if (i - 1 >= 0) a = nums[i - 1];
            if (i + 1 < n) b = nums[i + 1];
            int c = min(a, b);
            if (nums[i] >= c) ans1 += nums[i] - c + 1;
        }
        for (int i = 1; i < n; i += 2) {
            int a = 0, b = 0;
            if (i - 1 >= 0) a = nums[i - 1];
            if (i + 1 < n) b = nums[i + 1];
            int c = min(a, b);
            if (nums[i] >= c) ans2 += nums[i] - c + 1;
        }
        return min(ans1, ans2);
odd = 0, n = 0;
        for (int i = 0; i < n; i++) {
            it left = i= ? 1001 : nums[i - 1]
    
    }
};