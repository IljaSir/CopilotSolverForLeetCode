class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int cnt0 = 0, cnt1 = 0;
        for (auto c : s) {
            if (c == '0') cnt0++;
            else cnt1++;
        }
        if (abs(cnt0 - cnt1) > 1) return -1;
        int ans = 0;
        if (cnt0 > cnt1) {
            for (int i = 0; i < n; i += 2) {
                if (s[i] == '1') ans++;
            }
        } else if (cnt1 > cnt0) {
            for (int i = 0; i < n; i += 2) {
                if (s[i] == '0') ans++;
            }
        } else {
            int ans1 = 0, ans2 = 0;
            for (int i = 0; i < n; i += 2) {
                if (s[i] == '1') ans1++;
                else ans2++;
            }
            ans = min(ans1, ans2);
        }
        return ans;
    }
};