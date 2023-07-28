impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut result = 0;
        let mut board = vec![vec![false; n as usize]; n as usize];
        Self::solve(&mut board, &mut result, 0);
        result
    }
    
    fn solve(board: &mut Vec<Vec<bool>>, result: &mut i32, row: usize) {
        let n = board.len();
        if row == n {
            *result += 1;
            return;
        }
        
        for col in 0..n {
            if !Self::is_valid(board, row, col) {
                continue;
            }
            board[row][col] = true;
            Self::solve(board, result, row + 1);
            board[row][col] = false;
        }
    }
    
    fn is_valid(board: &Vec<Vec<bool>>, row: usize, col: usize) -> bool {
        let n = board.len();
        for i in 0..row {
            if board[i][col] {
                return false;
            }
        }
        let mut i = row as i32 - 1;
        let mut j = col as i32 - 1;
        while i >= 0 && j >= 0 {
            if board[i as usize][j as usize] {
                return false;
            }
            i -= 1;
            j -= 1;
        }
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