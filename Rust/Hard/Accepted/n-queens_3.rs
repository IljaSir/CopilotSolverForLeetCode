impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut res = vec![];
        let mut board = vec![vec!['.'; n as usize]; n as usize];
        Self::helper(0, n as usize, &mut board, &mut res);
        res
    }
    fn helper(row: usize, n: usize, board: &mut Vec<Vec<char>>, res: &mut Vec<Vec<String>>) {
        if row == n {
            res.push(board.iter().map(|v| v.iter().collect()).collect());
            return;
        }
        for col in 0..n {
            if Self::is_valid(row, col, n, board) {
                board[row][col] = 'Q';
                Self::helper(row + 1, n, board, res);
                board[row][col] = '.';
            }
        }
    }
    fn is_valid(row: usize, col: usize, n: usize, board: &Vec<Vec<char>>) -> bool {
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