impl Solution {
    pub fn solve_sudoku(board: &mut Vec<Vec<char>>) {
        
        let mut rows = vec![vec![false; 9]; 9];
        let mut cols = vec![vec![false; 9]; 9];
        let mut sub = vec![vec![vec![false; 9]; 3]; 3];
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] != '.' {
                    let idx = board[i][j] as usize - '1' as usize;
                    rows[i][idx] = true;
                    cols[j][idx] = true;
                    sub[i / 3][j / 3][idx] = true;
                }
            }
        }
        Self::dfs(board, &mut rows, &mut cols, &mut sub, 0, 0);
    }
    fn dfs(
        board: &mut Vec<Vec<char>>,
        rows: &mut Vec<Vec<bool>>,
        cols: &mut Vec<Vec<bool>>,
        sub: &mut Vec<Vec<Vec<bool>>>,
        i: usize,
        j: usize,
    ) -> bool {
        if j == 9 {
            return Self::dfs(board, rows, cols, sub, i + 1, 0);
        }
        if i == 9 {
            return true;
        }
        if board[i][j] != '.' {
            return Self::dfs(board, rows, cols, sub, i, j + 1);
        }
        for idx in 0..9 {
            if rows[i][idx] || cols[j][idx] || sub[i / 3][j / 3][idx] {
                continue;
            }
            rows[i][idx] = true;
            cols[j][idx] = true;
            sub[i / 3][j / 3][idx] = true;
            board[i][j] = (idx as u8 + '1' as u8) as char;
            if Self::dfs(board, rows, cols, sub, i, j + 1) {
                return true;
            }
            rows[i][idx] = false;
            cols[j][idx] = false;
            sub[i / 3][j / 3][idx] = false;
            board[i][j] = '.';
        }
        false
    }
}