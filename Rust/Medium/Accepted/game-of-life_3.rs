impl Solution {
    pub fn game_of_life(board: &mut Vec<Vec<i32>>) {
        

        let m = board.len();
        let n = board[0].len();
        let mut board2 = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let mut cnt = 0;
                if i > 0 {
                    if j > 0 {
                        cnt += board[i - 1][j - 1];
                    }
                    cnt += board[i - 1][j];
                    if j < n - 1 {
                        cnt += board[i - 1][j + 1];
                    }
                }
                if j > 0 {
                    cnt += board[i][j - 1];
                }
                if j < n - 1 {
                    cnt += board[i][j + 1];
                }
                if i < m - 1 {
                    if j > 0 {
                        cnt += board[i + 1][j - 1];
                    }
                    cnt += board[i + 1][j];
                    if j < n - 1 {
                        cnt += board[i + 1][j + 1];
                    }
                }
                if board[i][j] == 1 {
                    if cnt == 2 || cnt == 3 {
                        board2[i][j] = 1;
                    }
                } else if cnt == 3 {
                    board2[i][j] = 1;
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                board[i][j] = board2[i][j];
            }
        }
    }
}