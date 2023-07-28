impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut result: Vec<Vec<String>> = vec![];
        let mut board: Vec<String> = vec![];
        for _ in 0..n {
            board.push(".".repeat(n as usize));
        }
        let mut col: Vec<bool> = vec![false; n as usize];
        let mut diag1: Vec<bool> = vec![false; 2 * n as usize - 1];
        let mut diag2: Vec<bool> = vec![false; 2 * n as usize - 1];
        Self::backtrack(&mut result, &mut board, 0, n, &mut col, &mut diag1, &mut diag2);
        return result;
    }
    fn backtrack(result: &mut Vec<Vec<String>>, board: &mut Vec<String>, row: usize, n: i32, col: &mut Vec<bool>, diag1: &mut Vec<bool>, diag2: &mut Vec<bool>) {
        if row == n as usize {
            result.push(board.clone());
            return;
        }
        for i in 0..n as usize {
            if col[i] || diag1[row + i] || diag2[n as usize - 1 + row - i] {
                continue;
            }
            let mut s = board[row].clone();
            s.replace_range(i..i+1, "Q");
            board[row] = s;
            col[i] = true;
            diag1[row + i] = true;
            diag2[n as usize - 1 + row - i] = true;
            Self::backtrack(result, board, row + 1, n, col, diag1, diag2);
            s = board[row].clone();
            s.replace_range(i..i+1, ".");
            board[row] = s;
            col[i] = false;
            diag1[row + i] = false;
            diag2[n as usize - 1 + row - i] = false;
        }
    }
}