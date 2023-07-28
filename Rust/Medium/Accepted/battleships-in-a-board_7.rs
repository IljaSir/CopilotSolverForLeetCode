impl Solution {
    pub fn count_battleships(board: Vec<Vec<char>>) -> i32 {
        

        let mut res = 0;
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.') {
                    res += 1;
                }
            }
        }
        res
    }
}