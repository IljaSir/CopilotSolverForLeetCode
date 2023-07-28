class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        
        int n = nums.size();
        int min = nums[0];
        int max = -1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > min) {
                if (nums[i] - min > max) {
                    max = nums[i] - min;
                }
            }
            else {
                min = nums[i];
            }
        }
        return max;
    }
};