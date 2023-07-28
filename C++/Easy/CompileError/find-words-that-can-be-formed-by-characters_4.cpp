class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int cnt[26] = {0};
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        int ans = 0;
        for (string& w : words) {
            int c[26] = {0};
            bool ok = true;
            for (char c : w) {
                if (++c[c - 'a'] > cnt[c - 'a']) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans += w.size();
            }
        }
        return ans;
    }
};