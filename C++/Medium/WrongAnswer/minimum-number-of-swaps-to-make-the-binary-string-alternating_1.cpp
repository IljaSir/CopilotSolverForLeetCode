class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        if (abs(count0 - count1) > 1) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] != s[i % 2]) {
                count++;
            }
        }
        if (count0 == count1) {
            return min(count / 2, (n - count) / 2);
        }
        if (count0 > count1) {
            return count / 2;
        }
        return (n - count) / 2;
    }
};