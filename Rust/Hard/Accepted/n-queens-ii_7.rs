impl Solution {
    pub fn total_n_queens(n: i32) -> i32 {
        
        let mut res = 0;
        let mut board = vec![vec![0; n as usize]; n as usize];
        Self::helper(&mut board, 0, &mut res);
        res
    }
    fn helper(board: &mut Vec<Vec<i32>>, row: usize, res: &mut i32) {
        let n = board.len();
        if row == n {
            *res += 1;
            return;
        }
        for col in 0..n {
            if !Self::is_valid(board, row, col) {
                continue;
            }
            board[row][col] = 1;
            Self::helper(board, row + 1, res);
            board[row][col] = 0;
        }
    }
    fn is_valid(board: &Vec<Vec<i32>>, row: usize, col: usize) -> bool {
        let n = board.len();
        for i in 0..n {
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