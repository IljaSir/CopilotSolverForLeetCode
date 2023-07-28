class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int m = board.size();
        int n = board[0].size();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == ' ' || board[i][j] == word[0]) {
                    if(j == 0 || board[i][j - 1] == '#') {
                        int k = 0;
                        while(j + k < n && board[i][j + k] != '#') {
                            if(board[i][j + k] == word[k]) {
                                k++;
                                if(k == word.size()) {
                                    return true;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if(j == n - 1 || board[i][j + 1] == '#') {
                        int k = 0;
                        while(j - k >= 0 && board[i][j - k] != '#') {
                            if(board[i][j - k] == word[k]) {
                                k++;
                                if(k == word.size()) {
                                    return true;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if(i == 0 || board[i - 1][j] == '#') {
                        int k = 0;
                        while(i + k < m && board[i + k][j] != '#') {
                            if(board[i + k][j] == word[k]) {
                                k++;
                                if(k == word.size()) {
                                    return true;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if(i == m - 1 || board[i + 1][j] == '#') {
                        int k = 0;
                        while(i - k >= 0 && board[i - k][j] != '#') {
                            if(board[i - k][j] == word[k]) {
                                k++;
                                if(k == word.size()) {
                                    return true;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
};