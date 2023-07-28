class Solution {
public:
    int numSteps(string s) {
        
        int i = s.length() - 1;
        int count = 0;
        int carry = 0;
        while (i > 0) {
            if (s[i] == '1') {
                if (carry == 0) {
                    carry = 1;
                    count++;
                }
                count++;
            } else {
                if (carry == 1) {
                    count++;
                }
            }
            i--;
        }
        return count + carry;
    }
};