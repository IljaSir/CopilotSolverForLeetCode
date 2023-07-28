class Solution {
public:
    bool checkZeroOnes(string s) {
        
        int max1 = 0, max0 = 0, count1 = 0, count0 = 0;
        for (auto c : s) {
            if (c == '1') {
                count1++;
                count0 = 0;
            } else {
                count0++;
                count1 = 0;
            }
            max1 = max(max1, count1);
            max0 = max(max0, count0);
        }
        return max1 > max0;
    }
};