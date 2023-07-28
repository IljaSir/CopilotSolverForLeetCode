class Solution {
public:
    string baseNeg2(int n) {
        
        if (n == 0) return "0";
        string res;
        while (n) {
            res += to_string(n & 1);
            n = -(n >> 1);
        }
        reverse(res.begin(), res.end());
        return res;
    }
};