class Solution {
public:
    int beautySum(string s) {
        
        int res = 0;
        int n = s.size();
        for (int i = 0; i < n; ++i) {
            vector<int> cnt(26);
            for (int j = i; j < n; ++j) {
                ++cnt[s[j] - 'a'];
                int minCnt = n;
                int maxCnt = 0;
                for (int k = 0; k < 26; ++k) {
                    if (cnt[k] > 0) {
                        minCnt = min(minCnt, cnt[k]);
                        maxCnt = max(maxCnt, cnt[k]);
                    }
                }
                res += maxCnt - minCnt;
            }
        }
        return res;
    }
};