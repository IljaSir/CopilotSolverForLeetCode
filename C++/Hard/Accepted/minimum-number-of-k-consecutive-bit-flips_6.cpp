class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> flip(n + 1);
        int res = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt ^= flip[i];
            if (nums[i] == revCnt) {
                if (i + k > n) return -1;
                ++res;
                revCnt ^= 1;
                flip[i + k] ^= 1;
            }
        }
        return res;
    }
};