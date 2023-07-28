class Solution {
public:
    bool isIdealPermutation(vector<int>& nums) {
        
        int n = nums.size();
        int min = n;
        for (int i = n - 1; i > 1; i--) {
            min = std::min(min, nums[i]);
            if (nums[i - 2] > min) return false;
        }
        return true;
    }
};