class Solution {
public:
    bool checkZeroOnes(string s) {
        
        int one = 0, zero = 0;
        int oneMax = 0, zeroMax = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '0') {
                zero++;
                one = 0;
            } else {
                one++;
                zero = 0;
            }
            oneMax = max(oneMax, one);
            zeroMax = max(zeroMax, zero);
        }
        return oneMax > zeroMax;
    }
};