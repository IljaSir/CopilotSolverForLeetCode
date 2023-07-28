class Solution {
public:
    int largestVariance(string s) {
        
        int n = s.size();
        vector<t i = 0; i < s.size(); ++i) {
            int cnt[26] = {0};
            for (int j = i; j < s.size(); ++j) {
                ++cnt[s[j] - 'a'];
                int min_cnt = 0x7fffffff, max_cnt = 0;
                for (int k = 0; k < 26; ++k) {
                    if (cnt[k] > 0) {
                        min_cnt = min(min_cnt, cnt[k]);
                        max_cnt = max(max_cnt, cnt[k]);
                    }
                }
                ans = max(ans, max_cnt - min_cnt);
            }
        }
        return ans;
    }
};