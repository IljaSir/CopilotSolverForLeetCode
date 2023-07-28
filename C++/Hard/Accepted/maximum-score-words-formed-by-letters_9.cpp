class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        int ans = 0;
        int n = words.size();
        vector<int> cnt(26, 0);
        for (auto c : letters) {
            cnt[c - 'a']++;
        }
        for (int s = 1; s < (1 << n); s++) {
            int tmp = 0;
            vector<int> cc = cnt;
            for (int i = 0; i < n; i++) {
                if ((s >> i) & 1) {
                    bool ok = true;
                    for (auto c : words[i]) {
                        if (--cc[c - 'a'] < 0) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        for (auto c : words[i]) {
                            tmp += score[c - 'a'];
                        }
                    }
                }
            }
            ans = max(ans, tmp);
        }
        return ans;
    }
};