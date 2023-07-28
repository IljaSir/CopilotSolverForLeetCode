impl Solution {
    pub fn game_of_life(board: &mut Vec<Vec<i32>>) {
        

        // A live cell with fewer than two live neighbors dies as if caused by under-population.
        // A live cell with two or three live neighbors lives on to the next generation.
        // A live cell with more than three live neighbors dies, as if by over-population.
        // A dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        // 0 -> 1: 2
        // 1 -> 0: 3
        let m = board.len();
        let n = board[0].len();
        let mut neighbors = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let mut count = 0;
                for x in i.saturating_sub(1)..=i+1 {
                    for y in j.saturating_sub(1)..=j+1 {
                        if x == i && y == j {
                            continue;
                        }
                        if x < m && y < n {
                            count += board[x][y] & 1;
                        }
                    }
                }
                neighbors[i][j] = count;
            }
        }
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == 1 && (neighbors[i][j] < 2 || neighbors[i][j] > 3) {
                    board[i][j] = 3;
                }
                if board[i][j] == 0 && neighbors[i][j] == 3 {
                    board[i][j] = 2;
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                board[i][j] >>= 1;
            }
        }
    }
}