class Solution {
public:
    int numSteps(string s) {
        
        int ans = 0;
        int carry = 0;
        int n = s.size();
        for (int i = n - 1; i > 0; --i) {
            if (s[i] == '0') {
                ans += 1 + carry;
                carry = 0;
            } else {
                ans += 2 - carry;
                carry = 1;
            }
        }
        return ans + carry;
    }
};