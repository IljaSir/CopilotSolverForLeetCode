class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        
        int n = s.size();
        int m = target.size();
        if (n < m) return 0;
        vector<int> cnt(26, 0);
        for (char c : s) cnt[c - 'a']++;
        for (char c : target) {
            if (cnt[c - 'a'] == 0) return 0;
            cnt[c - 'a']--;
        }
        int maxCnt = 0;
        for (int i = 0; i < 26; i++) {
            maxCnt = max(maxCnt, cnt[i]);
        }
        if (maxCnt > (n - m) / m) return 0;
        return (n - m) / m + 1;
    }
};