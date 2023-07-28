impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut chessboard = vec![vec![false; n as usize]; n as usize];
        let mut counter = 0;
        Self::dfs(&mut chessboard, 0, &mut counter);
        counter
    }

    fn dfs(chessboard: &mut Vec<Vec<bool>>, row: usize, counter: &mut i32) {
        if row == chessboard.len() {
            *counter += 1;
            return;
        }
        for col in 0..chessboard.len() {
            if !chessboard[row][col] {
                Self::mark(chessboard, row, col, true);
                Self::dfs(chessboard, row + 1, counter);
                Self::mark(chessboard, row, col, false);
            }
        }
    }

    fn mark(chessboard: &mut Vec<Vec<bool>>, row: usize, col: usize, value: bool) {
        for i in 0..chessboard.len() {
            chessboard[row][i] = value;
            chessboard[i][col] = value;
        }
        let mut i = row as i32;
        let mut j = col as i32;
        while i >= 0 && j >= 0 {
            chessboard[i as usize][j as usize] = value;
            i -= 1;
            j -= 1;
        }
        let mut i = row as i32;
        let mut j = col as i32;
        while i >= 0 && j < chessboard.len() as i32 {
            chessboard[i as usize][j as usize] = value;
            i -= 1;
            j += 1;
        }
        let mut i = row as i32;
        let mut j = col as i32;
        while i < chessboard.len() as i32 && j >= 0 {
            chessboard[i as usize][j as usize] = value;
            i += 1;
            j -= 1;
        }
        let mut i = row as i32;
        let mut j = col as i32;
        while i < chessboard.len() as i32 && j < chessboard.len() as i32 {
            chessboard[i as usize][j as usize] = value;
            i += 1;
            j += 1;
        }
        chessboard[row][col] = !value
    }
}