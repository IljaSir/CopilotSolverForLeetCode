impl Solution {
    pub fn place_word_in_crossword(board: Vec<Vec<char>>, word: String) -> bool {
        
        let (m, n) = (board.len(), board[0].len());
        let word: Vec<char> = word.chars().collect();
        let (w, h) = (word.len(), word.len());
        for i in 0..m {
            for j in 0..n {
                if (i == 0 || board[i - 1][j] == '#') && i + h <= m {
                    let mut k = 0;
                    while k < h && (board[i + k][j] == ' ' || board[i + k][j] == word[k]) {
                        k += 1;
                    }
                    if k == h {
                        return true;
                    }
                }
                if (j == 0 || board[i][j - 1] == '#') && j + w <= n {
                    let mut k = 0;
                    while k < w && (board[i][j + k] == ' ' || board[i][j + k] == word[k]) {
                        k += 1;
                    }
                    if k == w {
                        return true;
                    }
                }
                if (i == 0 || board[i - 1][j] == '#') && i + w <= m {
                    let mut k = 0;
                    while k < w && (board[i + k][j] == ' ' || board[i + k][j] == word[w - 1 - k]) {
                        k += 1;
                    }
                    if k == w {
                        return true;
                    }
                }
                if (j == 0 || board[i][j - 1] == '#') && j + h <= n {
                    let mut k = 0;
                    while k < h && (board[i][j + k] == ' ' || board[i][j + k] == word[h - 1 - k]) {
                        k += 1;
                    }
                    if k == h {
                        return true;
                    }
                }
            }
        }
        false
    }
}