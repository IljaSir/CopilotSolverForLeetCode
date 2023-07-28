class Solution {
public:
    bool isIdealPermutation(vector<int>& nums) {
        
        int n = nums.size();
        int maxNum = -1;
        for (int i = 0; i < n - 2; ++i) {
            maxNum = max(maxNum, nums[i]);
            if (maxNum > nums[i + 2])
                return false;
        }
        return true;
    }
};