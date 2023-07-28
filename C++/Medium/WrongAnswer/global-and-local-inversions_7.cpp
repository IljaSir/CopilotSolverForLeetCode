class Solution {
public:
    bool isIdealPermutation(vector<int>& nums) {
        
        // global inversion = local inversion + (n - 2)
        // local inversion = nums[i] > nums[i + 1]
        // global inversion = nums[i] > nums[j] for i < j
        // nums[i] <= i + 1
        // nums[i] <= i + 2
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums[i] > i + 2) {
                return false;
            }
        }
        return true;
    }
};