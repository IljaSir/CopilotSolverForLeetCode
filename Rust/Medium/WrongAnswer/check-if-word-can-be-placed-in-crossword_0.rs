impl Solution {
    pub fn place_word_in_crossword(board: Vec<Vec<char>>, word: String) -> bool {
        
        let m = board.len();
        let n = board[0].len();
        let mut word = word.chars().collect::<Vec<char>>();
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == '#' {
                    continue;
                }
                if j > 0 && board[i][j-1] != '#' {
                    continue;
                }
                if j < n-1 && board[i][j+1] != '#' {
                    continue;
                }
                if i > 0 && board[i-1][j] != '#' {
                    continue;
                }
                if i < m-1 && board[i+1][j] != '#' {
                    continue;
                }
                let mut flag = true;
                for k in 0..word.len() {
                    if j+k >= n {
                        flag = false;
                        break;
                    }
                    if board[i][j+k] != ' ' && board[i][j+k] != word[k] {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    return true;
                }
                flag = true;
                for k in 0..word.len() {
                    if j-k < 0 {
                        flag = false;
                        break;
                    }
                    if board[i][j-k] != ' ' && board[i][j-k] != word[k] {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    return true;
                }
                flag = true;
                for k in 0..word.len() {
                    if i+k >= m {
                        flag = false;
                        break;
                    }
                    if board[i+k][j] != ' ' && board[i+k][j] != word[k] {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    return true;
                }
                flag = true;
                for k in 0..word.len() {
                    if i-k < 0 {
                        flag = false;
                        break;
                    }
                    if board[i-k][j] != ' ' && board[i-k][j] != word[k] {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    return true;
                }
            }
        }
        false
    }
}