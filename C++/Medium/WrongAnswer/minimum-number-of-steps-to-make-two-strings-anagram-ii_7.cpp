class Solution {
public:
    int minSteps(string s, string t) {
        
        int n = s.length();
        int m = t.length();
        if (n != m) return -1;
        int cnt[26] = {0};
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