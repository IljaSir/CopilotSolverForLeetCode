impl Solution {
    pub fn solve_sudoku(board: &mut Vec<Vec<char>>) {
        
        let mut row = vec![vec![false; 9]; 9];
        let mut col = vec![vec![false; 9]; 9];
        let mut block = vec![vec![false; 9]; 9];
        let mut spaces = Vec::new();
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] == '.' {
                    spaces.push((i, j));
                } else {
                    let k = (i / 3) * 3 + j / 3;
                    let num = board[i][j] as usize - '0' as usize - 1;
                    row[i][num] = true;
                    col[j][num] = true;
                    block[k][num] = true;
                }
            }
        }
        Self::dfs(0, &spaces, &mut row, &mut col, &mut block, board);
    }

    fn dfs(
        idx: usize,
        spaces: &Vec<(usize, usize)>,
        row: &mut Vec<Vec<bool>>,
        col: &mut Vec<Vec<bool>>,
        block: &mut Vec<Vec<bool>>,
        board: &mut Vec<Vec<char>>,
    ) -> bool {
        if idx == spaces.len() {
            return true;
        }
        let (i, j) = spaces[idx];
        let k = (i / 3) * 3 + j / 3;
        for num in 0..9 {
            if !row[i][num] && !col[j][num] && !block[k][num] {
                row[i][num] = true;
                col[j][num] = true;
                block[k][num] = true;
                board[i][j] = (num + 1) as u8 as char;
                if Self::dfs(idx + 1, spaces, row, col, block, board) {
                    return true;
                }
                row[i][num] = false;
                col[j][num] = false;
                block[k][num] = false;
            }
        }
        false
    }
}