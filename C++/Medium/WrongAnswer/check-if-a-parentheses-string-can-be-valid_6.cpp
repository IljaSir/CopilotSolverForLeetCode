class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.size();
        int cnt = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (locked[i] == '1') {
                if (s[i] == '(') {
                    cnt1++;
                } else {
                    cnt2++;
                }
            } else {
                if (s[i] == '(') {
                    cnt++;
                } else {
                    cnt--;
                }
            }
            if (cnt < 0) {
                if (cnt1 > 0) {
                    cnt1--;
                    cnt += 2;
                } else {
                    return false;
                }
            }
        }
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked[i] == '1') {
                if (s[i] == ')') {
                    cnt1++;
                } else {
                    cnt2++;
                }
            } else {
                if (s[i] == ')') {
                    cnt++;
                } else {
                    cnt--;
                }
            }
            if (cnt < 0) {
                if (cnt1 > 0) {
                    cnt1--;
                    cnt += 2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
};