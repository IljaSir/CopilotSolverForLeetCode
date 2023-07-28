class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        x = x & (-x);
        vector<int> res(2);
        for (int n : nums) {
            if (n & x) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
};