class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int count = 0;
        int maxCount = 0;
        int num = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] >= 0) {
                if (count == 0) {
                    num = nums[i];
                }
                count++;
            } else {
                if (num == nums[i]) {
                    count++;
                } else {
                    num = nums[i];
                    count = 1;
                }
            }
            maxCount = max(maxCount, count);
        }
        return maxCount;
    }
};