class Solution {
public:
    int beautySum(string s) {
        
        int N = s.length();
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            vector<int> cnt(26, 0);
            for (int j = i; j < N; ++j) {
                cnt[s[j] - 'a']++;
                int min_cnt = INT_MAX;
                int max_cnt = INT_MIN;
                for (int k = 0; k < 26; ++k) {
                    if (cnt[k] > 0) {
                        min_cnt = min(min_cnt, cnt[k]);
                        max_cnt = max(max_cnt, cnt[k]);
                    }
                }
                ans += max_cnt - min_cnt;
            }
        }
        return ans;
    }
};