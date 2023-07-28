impl Solution {
    pub fn game_of_life(board: &mut Vec<Vec<i32>>) {
        

        let m = board.len();
        let n = board[0].len();
        let mut next = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let mut count = 0;
                for (x, y) in &[
                    (i as i32 - 1, j as i32 - 1),
                    (i as i32 - 1, j as i32),
                    (i as i32 - 1, j as i32 + 1),
                    (i as i32, j as i32 - 1),
                    (i as i32, j as i32 + 1),
                    (i as i32 + 1, j as i32 - 1),
                    (i as i32 + 1, j as i32),
                    (i as i32 + 1, j as i32 + 1),
                ] {
                    if *x >= 0 && *x < m as i32 && *y >= 0 && *y < n as i32 && board[*x as usize][*y as usize] == 1 {
                        count += 1;
                    }
                }
                if board[i][j] == 1 {
                    if count < 2 || count > 3 {
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                } else {
                    if count == 3 {
                        next[i][j] = 1;
                    } else {
                        next[i][j] = 0;
                    }
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                board[i][j] = next[i][j];
            }
        }
    }
}