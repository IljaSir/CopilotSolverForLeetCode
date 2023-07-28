class Solution {
public:
    bool checkZeroOnes(string s) {
        
        int max0 = 0, max1 = 0, c0 = 0, c1 = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '0') {
                c0++;
                max0 = max(max0, c0);
                c1 = 0;
            } else {
                c1++;
                max1 = max(max1, c1);
                c0 = 0;
            }
        }
        return max1 > max0;
    }
};