class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        unordered_map<char, int> char_map;
        for (auto ch : letters) {
            char_map[ch]++;
        }
        return dfs(words, char_map, score, 0);
    }
    
    int dfs(vector<string>& words, unordered_map<char, int>& char_map, vector<int>& score, int idx) {
        if (idx == words.size()) {
            return 0;
        }
        int res = 0;
        int cur = dfs(words, char_map, score, idx + 1);
        if (isValid(words[idx], char_map)) {
            for (auto ch : words[idx]) {
                char_map[ch]--;
            }
            int score = getScore(words[idx], score);
            res = max(res, score + dfs(words, char_map, score, idx + 1));
            for (auto ch : words[idx]) {
                char_map[ch]++;
            }
        }
        return max(res, cur);
    }
    
    bool isValid(string word, unordered_map<char, int>& char_map) {
        for (auto ch : word) {
            if (char_map[ch] == 0) {
                return false;
            }
        }
        return true;
    }
    
    int getScore(string word, vector<int>& score) {
        int res = 0;
        for (auto ch : word) {
            res += score[ch - 'a'];
        }
        return res;
    }
};