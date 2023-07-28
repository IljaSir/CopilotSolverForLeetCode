impl Solution {
    pub fn game_of_life(board: &mut Vec<Vec<i32>>) {
        

        let m = board.len();
        let n = board[0].len();
        let mut next = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let mut count = 0;
                for x in i.saturating_sub(1)..=i+1 {
                    for y in j.saturating_sub(1)..=j+1 {
                        if x != i || y != j {
                            if x < m && y < n {
                                if board[x][y] == 1 {
                                    count += 1;
                                }
                            }
                        }
                    }
                }
                if board[i][j] == 1 {
                    if count == 2 || count == 3 {
                        next[i][j] = 1;
                    }
                } else {
                    if count == 3 {
                        next[i][j] = 1;
                    }
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                board[i][j] = next[i][j];
            }
        }