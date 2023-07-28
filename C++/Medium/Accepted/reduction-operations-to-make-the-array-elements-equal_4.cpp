class Solution {
public:
    int reductionOperations(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        sort(nums.begin(), nums.end());
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                res += (n - i);
            }
        }
        return res;
    }
};