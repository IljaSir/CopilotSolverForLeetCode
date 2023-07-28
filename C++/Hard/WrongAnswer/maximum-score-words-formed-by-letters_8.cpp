class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        int res = 0, n = words.size();
        vector<int> cnt(26, 0);
        for (auto c : letters) cnt[c - 'a']++;
        vector<int> wordScore(n, 0);
        for (int i = 0; i < n; ++i) {
            for (auto c : words[i]) wordScore[i] += score[c - 'a'];
        }
        function<void(int, vector<int>&)> dfs = [&](int i, vector<int>& cnt) {
            if (i == n) return;
            dfs(i + 1, cnt);
            bool isValid = true;
            for (auto c : words[i]) {
                cnt[c - 'a']--;
                if (cnt[c - 'a'] < 0) isValid = false;
            }
            if (isValid) {
                res = max(res, wordScore[i]);
                dfs(i + 1, cnt);
            }
            for (auto c : words[i]) cnt[c - 'a']++;
        };
        dfs(0, cnt);
        return res;
    }
};