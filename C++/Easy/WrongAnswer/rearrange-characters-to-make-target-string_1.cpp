class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        
        int n = s.size(), m = target.size();
        if (n < m) return 0;
        vector<int> cnt(26);
        for (char c: s) cnt[c - 'a']++;
        for (char c: target) cnt[c - 'a']--;
        for (int i = 0; i < 26; i++) if (cnt[i] < 0) return 0;
        int ans = 0;
        while (true) {
            for (char c: target) {
                if (cnt[c - 'a'] == 0) return ans;
                cnt[c - 'a']--;
            }
            ans++;
        }
        return ans;
    }
};