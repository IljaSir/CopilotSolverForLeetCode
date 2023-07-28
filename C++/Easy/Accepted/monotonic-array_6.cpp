class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        
        bool inc = true, dec = true;
        int n = nums.size();
        for (int i = 1; i < n; ++i) {
            inc &= nums[i-1] <= nums[i];
            dec &= nums[i-1] >= nums[i];
        }
        return inc || dec;
    }
};