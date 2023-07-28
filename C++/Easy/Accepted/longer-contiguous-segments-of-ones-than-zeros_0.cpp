class Solution {
public:
    bool checkZeroOnes(string s) {
        
        int count1 = 0;
        int count0 = 0;
        int max1 = 0;
        int max0 = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '1') {
                count1++;
                count0 = 0;
                max1 = max(max1, count1);
            }
            else if (s[i] == '0') {
                count0++;
                count1 = 0;
                max0 = max(max0, count0);
            }
        }
        return max1 > max0;
    }
};