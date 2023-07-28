class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (s[i] == '1') {
                    ++cnt1;
                } else {
                    ++cnt2;
                }
            } else {
                if (s[i] == '0') {
                    ++cnt1;
                } else {
                    ++cnt2;
                }
            }
        }
        if (cnt1 == cnt2) {
            return min(cnt1, cnt2);
        }
        if (n % 2 == 0) {
            return -1;
        } else {
            return min(cnt1, cnt2);
        }
    }
};