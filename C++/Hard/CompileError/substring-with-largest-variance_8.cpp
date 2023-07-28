class Solution {
public:
    int largestVariance(string s) {
        
        int n = s.size();
        vector<int> cnt(26, 0);
        vctor<int> prev(26, 0);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            ++cnt[s[i] - 'a'];
            for (int j = 0; j < 26; ++j) {
                res = max(res, cnt[j] - prev[j]);
            }
            prev = cnt;
        }
        return res
        vector<int> count(26, 0);
        int maxVariance = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                count[j] = 0;
            }
            for (int j = i; j < n; ++j) {
                ++count[s[j] - 'a'];
                int maxCount = 0, minCount = n;
                for (int k = 0; k < 26; ++k) {
                    if (count[k] > 0) {
                        maxCount = max(maxCount, count[k]);
                        minCount = min(minCount, count[k]);
                    }
                }
                maxVariance = max(maxVariance, maxCount - minCount);
            }
        }
        return maxVariance;
    }
};