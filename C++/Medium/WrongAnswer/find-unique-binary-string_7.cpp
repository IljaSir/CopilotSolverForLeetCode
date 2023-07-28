class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        
        int n = nums.size();
        int x = 0;
        for (auto& s : nums) {
            x <<= 1;
            x += s[0] - '0';
        }
        string res;
        while (n--) {
            res.push_back('0' + (x & 1));
            x >>= 1;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};