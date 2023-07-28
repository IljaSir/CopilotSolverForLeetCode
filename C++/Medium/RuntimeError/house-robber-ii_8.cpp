class Solution {
public:
    int rob(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 1) return nums[0];
        return max(robRange(nums, 0, n-2), robRange(nums, 1, n-1));
    }
    int robRange(vector<int>& nums, int start, int end) {
        int first = nums[start], second = max(nums[start], nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            int temp = second;
            second = max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
};