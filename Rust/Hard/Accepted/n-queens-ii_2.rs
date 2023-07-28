impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut board = vec![vec![false; n as usize]; n as usize];
        let mut count = 0;
        Self::solve(n as usize, 0, &mut board, &mut count);
        count
    }
    fn solve(n: usize, row: usize, board: &mut Vec<Vec<bool>>, count: &mut i32) {
        if row == n {
            *count += 1;
            return;
        }
        for col in 0..n {
            if !Self::is_valid(board, row, col, n) {
                continue;
            }
            board[row][col] = true;
            Self::solve(n, row + 1, board, count);
            board[row][col] = false;
        }
    }
    fn is_valid(board: &Vec<Vec<bool>>, row: usize, col: usize, n: usize) -> bool {
        // same col
        for i in 0..row {
            if board[i][col] {
                return false;
            }
        }
        // left up
        let mut i = row as i32 - 1;
        let mut j = col as i32 - 1;
        while i >= 0 && j >= 0 {
            if board[i as usize][j as usize] {
                return false;
            }
            i -= 1;
            j -= 1;
        }
        // right up
        let mut i = row as i32 - 1;
        let mut j = col as i32 + 1;
        while i >= 0 && j < n as i32 {
            if board[i as usize][j as usize] {
                return false;
            }
            i -= 1;
            j += 1;
        }
        true
    }
}