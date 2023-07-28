class Solution {
public:
    int minFlips(string s) {
        
        int n = s.size();
        s += s;
        int res = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int cnt0 = 0, cnt1 = 0;
            for (int j = i; j < i + n; ++j) {
                if (j % 2 == 0) {
                    if (s[j] == '1') cnt0++;
                    else cnt1++;
                } else {
                    if (s[j] == '1') cnt1++;
                    else cnt0++;
                }
            }
            res = min(res, min(cnt0, cnt1));
        }
        return res;
    }
};