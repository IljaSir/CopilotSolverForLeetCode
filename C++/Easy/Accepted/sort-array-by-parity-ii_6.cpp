class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        
        int odd = 1;
        int even = 0;
        int n = nums.size();
        while (odd < n && even < n) {
            while (odd < n && nums[odd] % 2 == 1) {
                odd += 2;
            }
            while (even < n && nums[even] % 2 == 0) {
                even += 2;
            }
            if (odd < n && even < n) {
                swap(nums[odd], nums[even]);
            }
        }
        return nums;
    }
};