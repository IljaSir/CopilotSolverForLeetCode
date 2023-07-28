class Solution {
public:
    bool isIdealPermutation(vector<int>& nums) {
        
        int n = nums.size();
        int maxVal = 0;
        for (int i = 0; i < n - 2; i++) {
            maxVal = max(maxVal, nums[i]);
            if (maxVal > nums[i + 2]) {
                return false;
            }
        }
        return true;
    }
};