class Solution {
public:
    int getMaximumGenerated(int n) {
        
        if (n == 0) return 0;
        if (n == 1) return 1;
        vector<int> nums(n+1);
        nums[0] = 0;
        nums[1] = 1;
        int max_num = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i/2] + (i & 1) * nums[i/2 + 1];
            max_num = max(max_num, nums[i]);
        }
        return max_num;
    }
};