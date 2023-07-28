class Solution {
public:
    int beautySum(string s) {
        
        int ans = 0;
        for (int i = 0; i < s.size(); ++i) {
            int cnt[26] = {0};
            for (int j = i; j < s.size(); ++j) {
                cnt[s[j] - 'a']++;
                int min = INT_MAX, max = INT_MIN;
                for (int k = 0; k < 26; ++k) {
                    if (cnt[k] != 0) {
                        min = std::min(min, cnt[k]);
                        max = std::max(max, cnt[k]);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }
};