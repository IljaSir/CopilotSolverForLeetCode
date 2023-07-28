class Solution {
public:
    string baseNeg2(int n) {
        
        string res;
        while(n) {
            res += (n & 1) + '0';
            n = -(n >> 1);
        }
        return res.empty() ? "0" : res;
    }
};