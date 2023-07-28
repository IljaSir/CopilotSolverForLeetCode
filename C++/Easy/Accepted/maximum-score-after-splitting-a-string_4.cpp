class Solution {
public:
    int maxScore(string s) {
        
        int n = s.size();
        int cnt0 = 0, cnt1 = 0;
        for (char c: s) {
            if (c == '0') cnt0++;
            else cnt1++;
        }
        int res = 0, sum0 = 0, sum1 = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == '0') sum0++;
            else sum1++;
            res = max(res, sum0 + cnt1 - sum1);
        }
        return res;
    }
};