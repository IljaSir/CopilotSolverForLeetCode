impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut solutions = Vec::new();
        let n = n as usize;
        let mut board = vec![vec!['.'; n]; n];
        Self::backtrack(&mut solutions, &mut board, 0, n);
        solutions
    }
    fn backtrack(solutions: &mut Vec<Vec<String>>, board: &mut Vec<Vec<char>>, row: usize, n: usize) {
        if row == n {
            solutions.push(board.iter().map(|row| row.iter().collect()).collect());
            return;
        }
        for col in 0..n {
            if !Self::is_valid(board, row, col, n) {
                continue;
            }
            board[row][col] = 'Q';
            Self::backtrack(solutions, board, row + 1, n);
            board[row][col] = '.';
        }
    }
    fn is_valid(board: &Vec<Vec<char>>, row: usize, col: usize, n: usize) -> bool {
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