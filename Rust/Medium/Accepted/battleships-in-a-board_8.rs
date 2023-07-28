impl Solution {
    pub fn count_battleships(board: Vec<Vec<char>>) -> i32 {
        

        let mut count = 0;
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if board[i][j] == 'X' {
                    if i == 0 && j == 0 {
                        count += 1;
                    } else if i == 0 {
                        if board[i][j - 1] == '.' {
                            count += 1;
                        }
                    } else if j == 0 {
                        if board[i - 1][j] == '.' {
                            count += 1;
                        }
                    } else {
                        if board[i - 1][j] == '.' && board[i][j - 1] == '.' {
                            count += 1;
                        }
                    }
                }
            }
        }
        count
    }
}