class Solution {
public:
    int largestVariance(string s) {
        
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt[26] = {0};
            int maxCnt = 0;
            for (int j = i; j < n; j++) {
                maxCnt = max(maxCnt, ++cnt[s[j] - 'a']);
                res = max(res, j - i + 1 - maxCnt);
            }
        }
        return res;
    }
};