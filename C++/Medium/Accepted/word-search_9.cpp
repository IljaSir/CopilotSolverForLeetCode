class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        int m = board.size();
        int n = board[0].size();
        int l = word.size();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word[0]){
                    if(dfs(board, word, i, j, 0, m, n, l)) return true;
                }
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>>& board, string& word, int i, int j, int k, int m, int n, int l){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word[k]) return false;
        if(k == l - 1) return true;
        char t = board[i][j];
        board[i][j] = '#';
        bool res = dfs(board, word, i + 1, j, k + 1, m, n, l) || dfs(board, word, i - 1, j, k + 1, m, n, l) || dfs(board, word, i, j + 1, k + 1, m, n, l) || dfs(board, word, i, j - 1, k + 1, m, n, l);
        board[i][j] = t;
        return res;
    }
};