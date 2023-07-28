class Solution {
public:
    string baseNeg2(int n) {
        
        string res;
        while (n) {
            res.push_back('0' + (n & 1));
            n = -(n >> 1);
        }
        return res.empty() ? "0" : res;
    }
};