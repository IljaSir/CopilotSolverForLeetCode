class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        vector<int> cnt(26);
        for (char c : letters) ++cnt[c - 'a'];
        int ans = 0;
        dfs(words, 0, cnt, score, ans);
        return ans;
    }
    
    void dfs(vector<string>& words, int i, vector<int>& cnt, vector<int>& score, int& ans) {
        if (i == words.size()) {
            int sum = 0;
            for (int i = 0; i < 26; ++i) {
                if (cnt[i] < 0) return;
                sum += cnt[i] * score[i];
            }
            ans = max(ans, sum);
            return;
        }
        dfs(words, i + 1, cnt, score, ans);
        for (char c : words[i]) --cnt[c - 'a'];
        dfs(words, i + 1, cnt, score, ans);
        for (char c : words[i]) ++cnt[c - 'a'];
    }
};