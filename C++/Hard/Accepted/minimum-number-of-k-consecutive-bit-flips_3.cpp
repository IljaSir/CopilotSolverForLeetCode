class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0, revCnt = 0;
        vector<int> diff(n + 1);
        for (int i = 0; i < n; ++i) {
            revCnt ^= diff[i];
            if (nums[i] == revCnt) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                diff[i + k] ^= 1;
            }
        }
        return ans;
    }
};