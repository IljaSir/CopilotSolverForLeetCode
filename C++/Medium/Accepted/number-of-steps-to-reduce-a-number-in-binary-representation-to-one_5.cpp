class Solution {
public:
    int numSteps(string s) {
        
        int n = s.size();
        int ret = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; --i) {
            ++ret;
            if (s[i] - '0' + carry == 1) {
                ++ret;
                carry = 1;
            }
        }
        return ret + carry;
    }
};