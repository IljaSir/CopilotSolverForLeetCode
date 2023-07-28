class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        
        vector<int> res;
        int x = 0;
        for (int i = 0; i < nums.size(); ++i) {
            x ^= nums[i];
            res.push_back(x);
        }
        int mask = (1 << maximumBit) - 1;
        for (int i = 0; i < res.size(); ++i) {
            res[i] = res[i] ^ mask;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};