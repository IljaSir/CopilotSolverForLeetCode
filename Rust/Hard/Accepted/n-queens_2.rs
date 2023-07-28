impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut res = vec![];
        let mut board = vec![vec!['.'; n as usize]; n as usize];
        Self::dfs(0, &mut board, &mut res);
        res
    }
    fn dfs(row: usize, board: &mut Vec<Vec<char>>, res: &mut Vec<Vec<String>>) {
        if row == board.len() {
            res.push(board.iter().map(|v| v.iter().collect()).collect());
            return;
        }
        for col in 0..board.len() {
            if !Self::is_valid(row, col, board) {
                continue;
            }
            board[row][col] = 'Q';
            Self::dfs(row + 1, board, res);
            board[row][col] = '.';
        }
    }
    fn is_valid(row: usize, col: usize, board: &Vec<Vec<char>>) -> bool {
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
        true
    }
}