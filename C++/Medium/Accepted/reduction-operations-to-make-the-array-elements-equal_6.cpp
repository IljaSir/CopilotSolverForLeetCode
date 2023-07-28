class Solution {
public:
    int reductionOperations(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int count = 0;
        int res = 0;
        for (int i = n - 1; i > 0; i--) {
            count++;
            if (nums[i] != nums[i - 1]) {
                res += count;
            }
        }
        return res;
    }
};