impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut board = vec![vec!['.'; n as usize]; n as usize];
        let mut res = vec![];
        Solution::dfs(n as usize, &mut board, 0, &mut res);
        res
    }
    
    fn dfs(n: usize, board: &mut Vec<Vec<char>>, row: usize, res: &mut Vec<Vec<String>>) {
        if row == n {
            let mut tmp = vec![];
            for i in 0..n {
                let mut s = String::new();
                for j in 0..n {
                    s.push(board[i][j]);
                }
                tmp.push(s);
            }
            res.push(tmp);
            return;
        }
        
        for col in 0..n {
            if !Solution::valid(board, row, col) {
                continue;
            }
            board[row][col] = 'Q';
            Solution::dfs(n, board, row + 1, res);
            board[row][col] = '.';
        }
    }
    
    fn valid(board: &Vec<Vec<char>>, row: usize, col: usize) -> bool {
        let n = board.len();
        for i in 0..n {
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