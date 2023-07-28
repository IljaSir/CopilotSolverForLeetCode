class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> result;
        unordered_set<string> wordSet(words.begin(), words.end());
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                string word;
                findWords(board, wordSet, i, j, word, result);
            }
        }
        return result;
    }
    
    void findWords(vector<vector<char>>& board, unordered_set<string>& wordSet, int i, int j, string& word, vector<string>& result) {
        if (i < 0 || j < 0 || i >= board.size() || j >= board[0].size() || board[i][j] == '#') {
            return;
        }
        word += board[i][j];
        if (wordSet.find(word) == wordSet.end()) {
            word.pop_back();
            return;
        }
        if (wordSet.find(word) != wordSet.end()) {
            result.push_back(word);
            wordSet.erase(word);
        }
        char c = board[i][j];
        board[i][j] = '#';
        findWords(board, wordSet, i - 1, j, word, result);
        findWords(board, wordSet, i + 1, j, word, result);
        findWords(board, wordSet, i, j - 1, word, result);
        findWords(board, wordSet, i, j + 1, word, result);
        board[i][j] = c;
        word.pop_back();
    }
};