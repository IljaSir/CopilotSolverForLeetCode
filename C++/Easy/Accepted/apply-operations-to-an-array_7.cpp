class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        
        int i = 0;
        while (i < nums.size() - 1) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
                i += 2;
            } else {
                i++;
            }
        }
        int j = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.size()) {
            nums[j] = 0;
            j++;
        }
        return nums;
    }
};