impl Solution {
    pub fn count_battleships(board: Vec<Vec<char>>) -> i32 {
        

        let m = board.len();
        let n = board[0].len();
        let mut count = 0;
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == 'X' {
                    if i > 0 && board[i - 1][j] == 'X' {
                        continue;
                    }
                    if j > 0 && board[i][j - 1] == 'X' {
                        continue;
                    }
                    count += 1;
                }
            }
        }
        count
    }
}