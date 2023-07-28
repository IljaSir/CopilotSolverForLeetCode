class Solution {
public:
    int minSteps(string s, string t) {
        
        int n = s.size();
        vector<int> cnt(26, 0);
        for (int i = 0; i < n; i++) {
            cnt[s[i] - 'a']++;
            cnt[t[i] - 'a']--;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) ans += cnt[i];
        }
        return ans;
    }
};