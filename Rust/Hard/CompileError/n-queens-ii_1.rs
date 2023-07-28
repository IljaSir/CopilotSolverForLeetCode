impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut board = vec![vec![false; n as usize]; n as usize];
        let mut result = 0;
        Self::dfs(&mut board, 0, &mut result);
        result
    }
    
    fn dfs(board: &mut Vec<Vec<bool>>, row: usize, result: &mut i32) {
        if row == board.len() {
            *result += 1;
        } else {
            for col in 0..board.len() {
                if !board[row][col] {
                    Self::mark(board, row, col, true);
                    Self::dfs(board, row + 1, result);
                    Self::mark(board, row, col, false);
                }
            }
        }
    }
    
    fn mark(board: &mut Vec<Vec<bool>>, row: usize, col: usize, is_mark: bool) {
        for i in 0..board.len() {
            board[i][col] = is_mark;
            if row + i < board.len() {
                if col + i < board.len() {
                    board[row + i][col + i] = is_mark;
                }
                if col >= i {
                    board[row + i][col - i] = is_mark;
                }
            }
            if row >= i {
                if col + i < board.len() {
                    board[row - i][col + i] = is_mark;
                }
                if col >= i {
                    board[row - i][col - i] = is_mark;
                }
            }
        }