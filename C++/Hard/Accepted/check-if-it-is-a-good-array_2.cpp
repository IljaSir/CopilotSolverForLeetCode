class Solution {
public:
    bool isGoodArray(vector<int>& nums) {
        
        int res = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }
};