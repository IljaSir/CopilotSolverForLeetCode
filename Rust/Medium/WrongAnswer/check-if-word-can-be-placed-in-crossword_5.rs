impl Solution {
    pub fn place_word_in_crossword(board: Vec<Vec<char>>, word: String) -> bool {
        
        let n = board.len();
        let m = board[0].len();
        let mut board = board;
        let word = word.chars().collect::<Vec<char>>();
        
        let mut i = 0;
        while i < n {
            let mut j = 0;
            while j < m {
                if board[i][j] == ' ' || board[i][j] == word[0] {
                    let mut k = j;
                    let mut l = 0;
                    while k < m && (board[i][k] == ' ' || board[i][k] == word[l]) {
                        k += 1;
                        l += 1;
                        if l == word.len() {
                            return true;
                        }
                    }
                    let mut k = j;
                    let mut l = 0;
                    while k < m && (board[i][k] == ' ' || board[i][k] == word[l]) {
                        k += 1;
                        l += 1;
                        if l == word.len() {
                            return true;
                        }
                    }
                    let mut k = i;
                    let mut l = 0;
                    while k < n && (board[k][j] == ' ' || board[k][j] == word[l]) {
                        k += 1;
                        l += 1;
                        if l == word.len() {
                            return true;
                        }
                    }
                    let mut k = i;
                    let mut l = 0;
                    while k < n && (board[k][j] == ' ' || board[k][j] == word[l]) {
                        k += 1;
                        l += 1;
                        if l == word.len() {
                            return true;
                        }
                    }
                }
                j += 1;
            }
            i += 1;
        }
        false
    }
}