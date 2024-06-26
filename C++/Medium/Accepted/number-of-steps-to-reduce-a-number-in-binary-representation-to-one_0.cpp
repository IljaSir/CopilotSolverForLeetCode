class Solution {
public:
    int numSteps(string s) {
        
        int n = s.size();
        int ans = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            ans++;
            if (s[i] - '0' + carry == 1) {
                ans++;
                carry = 1;
            }
        }
        return ans + carry;
    }
};