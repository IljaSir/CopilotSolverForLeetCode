class Solution {
public:
    int reductionOperations(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int res = 0, count = 0;
        for (int i = nums.size() - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                res += count + 1;
                count++;
            }
        }
        return res;
    }
};