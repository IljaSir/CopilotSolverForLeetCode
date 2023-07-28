class Solution {
public:
    string baseNeg2(int n) {
        
        string s;
        while (n) {
            s += (n & 1) + '0';
            n = -(n >> 1);
        }
        return s.empty() ? "0" : s;
    }
};