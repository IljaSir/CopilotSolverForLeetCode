class Solution {
public:
    int minFlips(string s) {
        
        int n = s.size();
        string s1 = s + s;
        string s2 = s + s;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s1[i] == '0') {
                    count1++;
                }
                if (s2[i] == '1') {
                    count2++;
                }
            } else {
                if (s1[i] == '1') {
                    count1++;
                }
                if (s2[i] == '0') {
                    count2++;
                }
            }
        }
        int count = min(count1, count2);
        for (int i = n; i < 2 * n; i++) {
            if (s1[i] == s1[i - n]) {
                if (s1[i] == '0') {
                    count1--;
                } else {
                    count1++;
                }
            }
            if (s2[i] == s2[i - n]) {
                if (s2[i] == '0') {
                    count2--;
                } else {
                    count2++;
                }
            }
            count = min(count, min(count1, count2));
        }
        return count;
    }
};