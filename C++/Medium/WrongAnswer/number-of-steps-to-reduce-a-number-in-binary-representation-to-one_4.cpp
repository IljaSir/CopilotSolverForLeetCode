class Solution {
public:
    int numSteps(string s) {
        
        int n = s.size();
        int cnt = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; --i) {
            if (s[i] == '0' + carry) {
                ++cnt;
                carry = 1;
            } else {
                cnt += 2;
            }
        }
        return cnt + carry;
    }
};