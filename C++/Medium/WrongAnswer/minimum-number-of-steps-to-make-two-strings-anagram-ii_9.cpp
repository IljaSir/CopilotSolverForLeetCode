class Solution {
public:
    int minSteps(string s, string t) {
        
        int n = s.length();
        int m = t.length();
        if (n != m) return -1;
        int cnt[26];
        for (int i = 0; i < 26; i++) cnt[i] = 0;
        for (int i = 0; i < n; i++) {
            cnt[s[i] - 'a']++;
            cnt[t[i] - 'a']--;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += cnt[i] > 0 ? cnt[i] : 0;
        }
        return ans;
    }
};