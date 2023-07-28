class Solution {
public:
    bool isIdealPermutation(vector<int>& nums) {
        
        int n = nums.size();
        int max = -1;
        for (int i = 0; i < n - 2; i++) {
            max = std::max(max, nums[i]);
            if (max > nums[i + 2]) return false;
        }
        return true;
    }
};