class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i > 0) {
                    if (nums[i - 1] > nums[i + 1]) {
                        nums[i + 1] = nums[i];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                }
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
};