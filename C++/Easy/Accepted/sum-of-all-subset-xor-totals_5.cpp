class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        
        int res = 0;
        for (int i = 0; i < (1 << nums.size()); ++i) {
            int cur = 0;
            for (int j = 0; j < nums.size(); ++j) {
                if (i & (1 << j)) {
                    cur ^= nums[j];
                }
            }
            res += cur;
        }
        return res;
    }
};