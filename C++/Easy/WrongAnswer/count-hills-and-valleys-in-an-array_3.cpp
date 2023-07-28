class Solution {
public:
    int countHillValley(vector<int>& nums) {
        
        int n = nums.size();
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) ||
                (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])) {
                count++;
            }
        }
        return count;
    }
};