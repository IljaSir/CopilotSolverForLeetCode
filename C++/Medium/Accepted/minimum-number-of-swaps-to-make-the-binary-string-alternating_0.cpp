class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
        }
        if (abs(cnt0 - cnt1) > 1) {
            return -1;
        }
        if (cnt0 > cnt1) {
            int ans = 0;
            for (int i = 0; i < n; i += 2) {
                if (s[i] == '1') {
                    ans++;
                }
            }
            return ans;
        } else if (cnt0 < cnt1) {
            int ans = 0;
            for (int i = 0; i < n; i += 2) {
                if (s[i] == '0') {
                    ans++;
                }
            }
            return ans;
        } else {
            int ans0 = 0;
            int ans1 = 0;
            for (int i = 0; i < n; i += 2) {
                if (s[i] == '1') {
                    ans0++;
                }
                if (s[i] == '0') {
                    ans1++;
                }
            }
            return min(ans0, ans1);
        }
    }
};