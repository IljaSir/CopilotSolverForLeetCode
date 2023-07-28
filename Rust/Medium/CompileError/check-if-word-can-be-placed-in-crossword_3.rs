impl Solution {
    pub fn place_word_in_crossword(board: Vec<Vec<char>>, word: String) -> bool {
        
        let mut board = board;
        let mut word = word.chars().collect::<Vec<char>>();
        let mut n = board.len();
        let mut m = board[0].len();
        for i in 0..n {
            for j in 0..m {
                if word[0] == board[i][j] {
                    if i == 0 || board[i - 1][j] == '#' {
                        if i + word.len() == n || board[i + word.len()][j] == '#' {
                            let mut k = 0;
                            for k in 0..word.len() {
                                if board[i + k][j] != ' ' && board[i + k][j] != word[k] {
                                    break;
                                }
                            }
                            if k == word.len() - 1 {
                                return true;
                            }
                        }
                    }
                    if j == 0 || board[i][j - 1] == '#' {
                        if j + word.len() == m || board[i][j + word.len()] == '#' {
                            let mut k = 0;
                            for k in 0..word.len() {
                                if board[i][j + k] != ' ' && board[i][j + k] != word[k] {
                                    break;
                                }
                            }
                            if k == word.len() - 1 {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        word.reverse();
        for i in 0..n {
            for j in 0..m {
                if word[0] == board[i][j] {
                    if i == 0 || board[i - 1][j] == '#' {
                        if i + word.len() == n || board[i + word.len()][j] == '#' {
                            let mut k = 0;
                            for k in 0..word.len() {
                                if board[i + k][j] != ' ' && board[i + k][j] != word[k] {
                                    break;
                                }
                            }
                            if k == word.len() - 1 {
                                return true;
                            }
                        }
                    }
                    if j == 0 || board[i][j - 1] == '#' {
                        if j + word.len() == m || board[i][j + word.len()] == '#' {
                            let mut k = 0;
                            for k in 0..word
    }
}