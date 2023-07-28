class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int res = 0;
        int n = words.size();
        int m = chars.size();
        vector<int> cnt(26, 0);
        for (int i = 0; i < m; i++) {
            cnt[chars[i] - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            vector<int> cnt2(26, 0);
            for (int j = 0; j < words[i].size(); j++) {
                cnt2[words[i][j] - 'a']++;
            }
            bool ok = true;
            for (int j = 0; j < 26; j++) {
                if (cnt2[j] > cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res += words[i].size();
            }
        }
        return res;
    }
};