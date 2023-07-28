class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        
        int n = nums.size();
        int mask = (1 << n) - 1;
        for (auto& s : nums) {
            int val = 0;
            for (char c : s) {
                val = (val << 1) + (c - '0');
            }
            mask &= ~(1 << val);
        }
        string res;
        for (int i = 0; i < n; ++i) {
            res.push_back((mask & (1 << i)) ? '1' : '0');
        }
        return res;
    }
};