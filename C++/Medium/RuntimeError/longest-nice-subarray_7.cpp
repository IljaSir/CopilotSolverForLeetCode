class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        
        unordered_map<int, int> m;
        int res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int mask = 0;
            for (int j = i; j < nums.size(); ++j) {
                mask ^= 1 << (nums[j] - 'a');
                if (m.find(mask) != m.end()) {
                    res = max(res, j - i + 1);
                }
            }
        }
        return res;
    }
};