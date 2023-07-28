impl Solution {
    pub fn place_word_in_crossword(board: Vec<Vec<char>>, word: String) -> bool {
        
        let m = board.len();
        let n = board[0].len();
        let mut board = board;
        let word: Vec<char> = word.chars().collect();
        let wlen = word.len();
        let mut rboard = vec![vec![' '; n]; m];
        for i in 0..m {
            for j in 0..n {
                rboard[i][j] = board[m-i-1][j];
            }
        }
        let mut cboard = vec![vec![' '; m]; n];
        for i in 0..m {
            for j in 0..n {
                cboard[j][i] = board[i][j];
            }
        }
        let mut rcboard = vec![vec![' '; m]; n];
        for i in 0..m {
            for j in 0..n {
                rcboard[j][i] = rboard[i][j];
            }
        }
        let boards = vec![board, rboard, cboard, rcboard];
        for board in boards {
            for i in 0..m {
                for j in 0..n {
                    if board[i][j] == ' ' {
                        let mut flag = true;
                        for k in 0..wlen {
                            if j+k >= n || board[i][j+k] != ' ' && board[i][j+k] != word[k] {
                                flag = false;
                                break;
                            }
                        }
                        if flag {
                            return true;
                        }
                        flag = true;
                        for k in 0..wlen {
                            if i+k >= m || board[i+k][j] != ' ' && board[i+k][j] != word[k] {
                                flag = false;
                                break;
                            }
                        }
                        if flag {
                            return true;
                        }
                    }
                }
            }
        }
        false
    }
}