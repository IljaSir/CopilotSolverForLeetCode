class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        unordered_map<char, int> m;
        for (int i = 0; i < letters.size(); ++i) {
            m[letters[i]]++;
        }
        return dfs(words, 0, m, score);
    }
    int dfs(vector<string>& words, int pos, unordered_map<char, int> m, vector<int>& score) {
        if (pos == words.size()) return 0;
        int res = dfs(words, pos + 1, m, score);
        string word = words[pos];
        int sum = 0;
        for (int i = 0; i < word.size(); ++i) {
            if (m[word[i]] == 0) {
                for (int j = 0; j < i; ++j) {
                    m[word[j]]++;
                }
                return res;
            }
            m[word[i]]--;
            sum += score[word[i] - 'a'];
        }
        res = max(res, sum + dfs(words, pos + 1, m, score));
        return res;
    }
};