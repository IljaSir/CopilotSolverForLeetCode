class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (s[i] == '1') {
                    ++cnt1;
                }
                else {
                    ++cnt2;
                }
            }
            else {
                if (s[i] == '0') {
                    ++cnt1;
                }
                else {
                    ++cnt2;
                }
            }
        }
        if (cnt1 != cnt2 && cnt1 != cnt2 - 1 && cnt1 != cnt2 + 1) {
            return -1;
        }
        int ans = 0;
        if (cnt1 == cnt2) {
            int ans1 = 0, ans2 = 0;
            for (int i = 0; i < n; ++i) {
                if (i % 2 == 0) {
                    if (s[i] == '1') {
                        ++ans1;
                    }
                }
                else {
                    if (s[i] == '0') {
                        ++ans1;
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                if (i % 2 == 0) {
                    if (s[i] == '0') {
                        ++ans2;
                    }
                }
                else {
                    if (s[i] == '1') {
                        ++ans2;
                    }
                }
            }
            ans = min(ans1, ans2);
        }
        else if (cnt1 > cnt2) {
            for (int i = 0; i < n; ++i) {
                if (i % 2 == 0) {
                    if (s[i] == '1') {
                        ++ans;
                    }
                }
                else {
                    if (s[i] == '0') {
                        ++ans;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < n; ++i) {
                if (i % 2 == 0) {
                    if (s[i] == '0') {
                        ++ans;
                    }
                }
                else {
                    if (s[i] == '1') {
                        ++ans;
                    }
                }
    }
};