impl Solution {
    pub fn game_of_life(board: &mut Vec<Vec<i32>>) {
        

        let mut new_board = board.clone();
        for (i, row) in board.iter().enumerate() {
            for (j, val) in row.iter().enumerate() {
                let mut count = 0;
                if i > 0 && j > 0 && board[i - 1][j - 1] == 1 {
                    count += 1;
                }
                if i > 0 && board[i - 1][j] == 1 {
                    count += 1;
                }
                if i > 0 && j < board[0].len() - 1 && board[i - 1][j + 1] == 1 {
                    count += 1;
                }
                if j > 0 && board[i][j - 1] == 1 {
                    count += 1;
                }
                if j < board[0].len() - 1 && board[i][j + 1] == 1 {
                    count += 1;
                }
                if i < board.len() - 1 && j > 0 && board[i + 1][j - 1] == 1 {
                    count += 1;
                }
                if i < board.len() - 1 && board[i + 1][j] == 1 {
                    count += 1;
                }
                if i < board.len() - 1 && j < board[0].len() - 1 && board[i + 1][j + 1] == 1 {
                    count += 1;
                }
                if *val == 0 {
                    if count == 3 {
                        new_board[i][j] = 1;
                    }
                } else {
                    if count < 2 || count > 3 {
                        new_board[i][j] = 0;
                    }
                }
            }
        }
        *board = new_board;
    }
}