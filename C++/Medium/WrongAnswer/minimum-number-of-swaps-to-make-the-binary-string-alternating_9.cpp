class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int ans = INT_MAX;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '0') {
                cnt++;
            }
        }
        if (abs(cnt - (n - cnt)) > 1) {
            return -1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (s[i] == '0') {
                    a++;
                }
            } else {
                if (s[i] == '1') {
                    a++;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (s[i] == '1') {
                    b++;
                }
            } else {
                if (s[i] == '0') {
                    b++;
                }
            }
        }
        if (cnt == n - cnt) {
            return min(a, b) / 2;
        } else if (cnt > n - cnt) {
            return a / 2;
        } else {
            return b / 2;
        }
    }
};