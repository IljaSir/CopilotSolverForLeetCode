class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int min = nums[0];
        int max = nums[0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int minDelete = minIndex;
        int maxDelete = nums.size() - maxIndex - 1;
        if (minIndex > maxIndex) {
            return minDelete + maxDelete - 1;
        } else {
            return minDelete + maxDelete;
        }
    }
};