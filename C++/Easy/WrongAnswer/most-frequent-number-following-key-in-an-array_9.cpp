class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int max = 0;
        int maxTarget = 0;
        int count = 0;
        int target = 0;
        bool foundKey = false;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == key) {
                foundKey = true;
                if (count > max) {
                    max = count;
                    maxTarget = target;
                }
                count = 0;
            } else if (foundKey) {
                count++;
                target = nums[i];
            }
        }
        if (count > max) {
            max = count;
            maxTarget = target;
        }
        return maxTarget;
    }
};