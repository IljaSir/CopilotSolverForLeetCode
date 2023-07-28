impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut ans = 0;
        let n = n as usize;
        let mut board = vec![vec!['.'; n]; n];
        Self::dfs(0, n, &mut board, &mut ans);
        ans
    }
    fn dfs(row: usize, n: usize, board: &mut Vec<Vec<char>>, ans: &mut i32) {
        if row == n {
            *ans += 1;
            return;
        }
        for col in 0..n {
            if !Self::is_valid(row, col, n, board) {
                continue;
            }
            board[row][col] = 'Q';
            Self::dfs(row + 1, n, board, ans);
            board[row][col] = '.';
        }
    }
    fn is_valid(row: usize, col: usize, n: usize, board: &mut Vec<Vec<char>>) -> bool {
        for i in 0..row {
            if board[i][col] == 'Q' {
                return false;
            }
        }
        let mut i = row as i32 - 1;
        let mut j = col as i32 - 1;
        while i >= 0 && j >= 0 {
            if board[i as usize][j as usize] == 'Q' {
                return false;
            }
            i -= 1;
            j -= 1;
        }
        let mut i = row as i32 - 1;
        let mut j = col as i32 + 1;
        while i >= 0 && j < n as i32 {
            if board[i as usize][j as usize] == 'Q' {
                return false;
            }
            i -= 1;
            j += 1;
        }
        true
    }
}