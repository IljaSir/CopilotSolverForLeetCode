class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        int bit = 1;
        while ((xorSum & bit) == 0) {
            bit <<= 1;
        }
        vector<int> ans(2, 0);
        for (int num : nums) {
            if ((num & bit) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
};