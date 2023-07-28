class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        int n = words.size();
        int m = letters.size();
        vector<int> cnt(26, 0);
        for (int i = 0; i < m; ++i) {
            cnt[letters[i] - 'a']++;
        }
        return dfs(words, cnt, score, 0);
    }
    int dfs(vector<string>& words, vector<int>& cnt, vector<int>& score, int pos) {
        int n = words.size();
        if (pos == n) return 0;
        int maxScore = 0;
        vector<int> cntCopy = cnt;
        bool canForm = true;
        for (char c : words[pos]) {
            if (cnt[c - 'a'] == 0) {
                canForm = false;
                break;
            }
            cnt[c - 'a']--;
        }
        if (canForm) {
            int curScore = 0;
            for (char c : words[pos]) {
                curScore += score[c - 'a'];
            }
            maxScore = max(maxScore, curScore + dfs(words, cnt, score, pos + 1));
        }
        cnt = cntCopy;
        maxScore = max(maxScore, dfs(words, cnt, score, pos + 1));
        return maxScore;
    }
};