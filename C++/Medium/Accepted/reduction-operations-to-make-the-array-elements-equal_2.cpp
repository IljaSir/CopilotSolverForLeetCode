class Solution {
public:
    int reductionOperations(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int result = 0;
        for (int i = nums.size() - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                result += nums.size() - i;
            }
        }
        return result;
    }
};