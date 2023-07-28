impl Solution {
    pub fn place_word_in_crossword(board: Vec<Vec<char>>, word: String) -> bool {
        
        let word = word.chars().collect::<Vec<char>>();
        let m = board.len();
        let n = board[0].len();
        let mut rows = vec![vec![]; m];
        let mut cols = vec![vec![]; n];
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == '#' {
                    continue;
                }
                rows[i].push(j);
            }
        }
        for j in 0..n {
            for i in 0..m {
                if board[i][j] == '#' {
                    continue;
                }
                cols[j].push(i);
            }
        }
        for i in 0..m {
            if rows[i].len() < word.len() {
                continue;
            }
            for j in 0..=rows[i].len() - word.len() {
                let mut flag = true;
                for k in 0..word.len() {
                    if board[i][rows[i][j + k]] != ' ' && board[i][rows[i][j + k]] != word[k] {
                        flag = false;
                        break;
                    }
                }
                if flag && (j == 0 || board[i][rows[i][j - 1]] == '#') && (j + word.len() == rows[i].len() || board[i][rows[i][j + word.len()]] == '#') {
                    return true;
                }
            }
        }
        for i in 0..n {
            if cols[i].len() < word.len() {
                continue;
            }
            for j in 0..=cols[i].len() - word.len() {
                let mut flag = true;
                for k in 0..word.len() {
                    if board[cols[i][j + k]][i] != ' ' && board[cols[i][j + k]][i] != word[k] {
                        flag = false;
                        break;
                    }
                }
                if flag && (j == 0 || board[cols[i][j - 1]][i] == '#') && (j + word.len() == cols[i].len() || board[cols[i][j + word.len()]][i] == '#') {
                    return true;
                }
            }
        }
        false
    }
}