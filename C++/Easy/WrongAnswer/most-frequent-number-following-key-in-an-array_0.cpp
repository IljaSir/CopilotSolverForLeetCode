class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int count = 0;
        int maxCount = 0;
        int target = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == key) {
                for (int j = i + 1; j < nums.size(); j++) {
                    if (nums[j] == target) {
                        count++;
                    } else {
                        if (count > maxCount) {
                            maxCount = count;
                            target = nums[j];
                        }
                        count = 0;
                    }
                }
            }
        }
        return target;
    }
};