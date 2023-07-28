impl Solution {
    pub fn solve(board: &mut Vec<Vec<char>>) {
        

        let m = board.len();
        let n = board[0].len();
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == 'O' {
                    if i == 0 || j == 0 || i == m - 1 || j == n - 1 {
                        Self::dfs(board, i, j);
                    }
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == 'O' {
                    board[i][j] = 'X';
                } else if board[i][j] == '#' {
                    board[i][j] = 'O';
                }
            }
        }
    }
    fn dfs(board: &mut Vec<Vec<char>>, i: usize, j: usize) {
        if i < 0 || j < 0 || i >= board.len() || j >= board[0].len() {
            return;
        }
        if board[i][j] == 'O' {
            board[i][j] = '#';
            Self::dfs(board, i + 1, j);
            Self::dfs(board, i - 1, j);
            Self::dfs(board, i, j + 1);
            Self::dfs(board, i, j - 1);
        }
    }
}