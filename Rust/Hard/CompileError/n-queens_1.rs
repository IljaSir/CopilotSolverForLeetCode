impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut board = vec![vec!['.'; n as usize]; n as usize];
        let mut result = vec![];
        Self::solve(&mut board, 0, &mut result);
        result
    }
    
    fn solve(board: &mut Vec<Vec<char>>, row: usize, result: &mut Vec<Vec<String>>) {
        if row == board.len() {
            result.push(board.iter().map(|s| s.iter().collect()).collect());
            return;
        }
        for col in 0..board.len() {
            if !Self::is_valid(board, row, col) {
                continue;
            }
            board[row][col] = 'Q';
            Self::solve(board, row + 1, result);
            board[row][col] = '.';
        }
    }
    
    fn is_valid(board: &Vec<Vec<char>>, row: usize, col: usize) -> bool {
        for i in 0..board.len() {
            if board[i][col] == 'Q' {
                return false;
            }
        }
        for i in 0..board.len() {
            if board[row][i] == 'Q' {
                return false;
            }
        }
        let mut i = row as i32;
        let mut j = col as i32;
        while i >= 0 && j >= 0 {
            if board[i as usize][j as usize] == 'Q' {
                return false;
            }
            i -= 1;
            j -= 1;
        }
        let mut i = row as i32;
        let mut j = col as i32;
        while i < board.len() as i32 && j >= 0 {
            if board[i as usize][j as usize] == 'Q' {
                return false;
            }
            i += 1;
            j -= 1;
        }
        let mut i = row as i32;
        let mut j = col as i32;
        while i < board.len() as i32 && j < board.len() as i32 {
            if board[i as usize][j as usize] == 'Q' {
                return false;
            }
            i += 1;
            j += 1;
        }
        let mut i = row as i32;
        let mut j = col as i32;
        while i >= 0 && j < board
    }
}