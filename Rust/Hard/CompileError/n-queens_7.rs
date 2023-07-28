impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut res: Vec<Vec<String>> = Vec::new();
        let mut board: Vec<String> = vec![String::new(); n as usize];
        let mut cols: Vec<bool> = vec![false; n as usize];
        let mut diag1: Vec<bool> = vec![false; 2 * n as usize - 1];
        let mut diag2: Vec<bool> = vec![false; 2 * n as usize - 1];
        Self::backtrack(&mut res, &mut board, &mut cols, &mut diag1, &mut diag2, n as usize);
        res
    }
    
    fn backtrack(res: &mut Vec<Vec<String>>, board: &mut Vec<String>, cols: &mut Vec<bool>, diag1: &mut Vec<bool>, diag2: &mut Vec<bool>, n: usize) {
        if board.len() == n {
            res.push(board.clone());
            return;
        }
        for i in 0..n {
            let id1 = n - 1 + board.len() as i32 - i as i32;
            let id2 = board.len() + i;
            if cols[i] || diag1[id1 as usize] || diag2[id2 as usize] {
                continue;
            }
            cols[i] = true;
            diag1[id1 as usize] = true;
            diag2[id2 as usize] = true;
            board[board.len()] = Self::generate_row(i, n);
            Self::backtrack(res, board, cols, diag1, diag2, n);
            board.pop();
            cols[i] = false;
            diag1[id1 as usize] = false;
            diag2[id2 as usize] = false;
        }
    }
    
    fn generate_row(i: usize, n: usize) -> String {
        let mut s = String::new();
        for j in 0..n {
            if j == i {
                s.push('Q');
            } else {
                s.push('.');
            }
        }
        s
    }
}