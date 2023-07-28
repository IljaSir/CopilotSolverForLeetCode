impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut result = Vec::new();
        let mut board = vec![vec!['.'; n as usize]; n as usize];
        Self::helper(n as usize, 0, &mut board, &mut result);
        result
    }
    fn helper(n: usize, row: usize, board: &mut Vec<Vec<char>>, result: &mut Vec<Vec<String>>) {
        if row == n {
            result.push(board.iter().map(|row| row.iter().collect()).collect());
            return;
        }
        for col in 0..n {
            if Self::is_valid(board, row, col) {
                board[row][col] = 'Q';
                Self::helper(n, row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }
    fn is_valid(board: &Vec<Vec<char>>, row: usize, col: usize) -> bool {
        for i in 0..row {
            if board[i][col] == 'Q' {
                return false;
            }
        }
        for i in 0..col {
            if board[row][i] == 'Q' {
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
        while i >= 0 && j < board[row].len() as i32 {
            if board[i as usize][j as usize] == 'Q' {
                return false;
            }
            i -= 1;
            j += 1;
        }
        true
    }
}