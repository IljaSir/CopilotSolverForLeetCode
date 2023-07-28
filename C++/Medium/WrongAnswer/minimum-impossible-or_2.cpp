class Solution {
public:
    int minImpossibleOR(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int res = 1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > res) return res;
            res |= nums[i];
        }
        return res;
    }
};