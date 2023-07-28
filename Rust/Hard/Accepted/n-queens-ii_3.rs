impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut board = vec![vec![0; n as usize]; n as usize];
        let mut count = 0;
        Self::dfs(&mut board, 0, &mut count);
        count
    }
    fn dfs(board: &mut Vec<Vec<i32>>, row: usize, count: &mut i32) {
        let n = board.len();
        if row == n {
            *count += 1;
            return;
        }
        for col in 0..n {
            if !Self::is_valid(board, row, col) {
                continue;
            }
            board[row][col] = 1;
            Self::dfs(board, row + 1, count);
            board[row][col] = 0;
        }
    }
    fn is_valid(board: &mut Vec<Vec<i32>>, row: usize, col: usize) -> bool {
        let n = board.len();
        for i in 0..row {
            if board[i][col] == 1 {
                return false;
            }
        }
        let mut i = row as i32 - 1;
        let mut j = col as i32 - 1;
        while i >= 0 && j >= 0 {
            if board[i as usize][j as usize] == 1 {
                return false;
            }
            i -= 1;
            j -= 1;
        }
        let mut i = row as i32 - 1;
        let mut j = col as i32 + 1;
        while i >= 0 && j < n as i32 {
            if board[i as usize][j as usize] == 1 {
                return false;
            }
            i -= 1;
            j += 1;
        }
        true
    }
}