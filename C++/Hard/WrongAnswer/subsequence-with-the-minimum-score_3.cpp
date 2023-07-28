class Solution {
public:
    int minimumScore(string s, string t) {
        
        int ans = 0;
        vector<int> cnt(26, 0);
        for (auto c : s) {
            cnt[c - 'a']++;
        }
        for (auto c : t) {
            if (cnt[c - 'a'] > 0) {
                cnt[c - 'a']--;
            } else {
                ans++;
            }
        }
        return ans;
    }
};