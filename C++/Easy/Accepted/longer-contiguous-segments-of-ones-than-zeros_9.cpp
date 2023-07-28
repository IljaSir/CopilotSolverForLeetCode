class Solution {
public:
    bool checkZeroOnes(string s) {
        
        int len = s.size();
        int zero = 0;
        int one = 0;
        int maxZero = 0;
        int maxOne = 0;
        for (int i = 0; i < len; i++) {
            if (s[i] == '0') {
                zero++;
                one = 0;
            } else {
                one++;
                zero = 0;
            }
            maxZero = max(maxZero, zero);
            maxOne = max(maxOne, one);
        }
        return maxOne > maxZero;
    }
};