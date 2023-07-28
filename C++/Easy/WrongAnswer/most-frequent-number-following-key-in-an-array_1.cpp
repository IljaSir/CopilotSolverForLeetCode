class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int maxCount = 0;
        int maxTarget = 0;
        int count = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i-1] == key) {
                if (nums[i] == maxTarget) {
                    count++;
                } else {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    maxTarget = nums[i];
                    count = 1;
                }
            }
        }
        if (count > maxCount) {
            maxCount = count;
        }
        return maxTarget;
    }
};