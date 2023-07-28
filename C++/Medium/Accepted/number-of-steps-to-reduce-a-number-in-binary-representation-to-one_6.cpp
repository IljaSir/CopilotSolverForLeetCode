class Solution {
public:
    int numSteps(string s) {
        
        int steps = 0;
        int carry = 0;
        int i = s.length() - 1;
        while (i > 0) {
            if (s[i] == '0') {
                if (carry == 1) {
                    steps += 2;
                } else {
                    steps += 1;
                }
            } else {
                if (carry == 1) {
                    steps += 1;
                } else {
                    steps += 2;
                    carry = 1;
                }
            }
            i--;
        }
        return steps + carry;
    }
};