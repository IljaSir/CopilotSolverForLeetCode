impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut result = 0;
        let mut board = vec![vec!['.'; n as usize]; n as usize];
        Self::backtrack(&mut result, &mut board, 0);
        return result;
    }
    fn backtrack(result: &mut i32, board: &mut Vec<Vec<char>>, row: usize) {
        if row == board.len() {
            *result += 1;
            return;
        }
        for col in 0..board.len() {
            if !Self::is_valid(board, row, col) {
                continue;
            }
            board[row][col] = 'Q';
            Self::backtrack(result, board, row + 1);
            board[row][col] = '.';
        }
    }
    fn is_valid(board: &Vec<Vec<char>>, row: usize, col: usize) -> bool {
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
        while i >= 0 && j < board.len() as i32 {
            if board[i as usize][j as usize] == 'Q' {
                return false;
            }
            i -= 1;
            j += 1;
        }
        return true;
    }
}