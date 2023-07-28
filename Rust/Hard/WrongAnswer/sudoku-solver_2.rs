impl Solution {
    pub fn solve_sudoku(board: &mut Vec<Vec<char>>) {
        
        let mut row: Vec<Vec<bool>> = vec![vec![false; 9]; 9];
        let mut col: Vec<Vec<bool>> = vec![vec![false; 9]; 9];
        let mut boxs: Vec<Vec<bool>> = vec![vec![false; 9]; 9];
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] == '.' {
                    continue;
                }
                let num = (board[i][j] as u8 - '0' as u8) as usize - 1;
                row[i][num] = true;
                col[j][num] = true;
                boxs[(i / 3) * 3 + j / 3][num] = true;
            }
        }
        Self::dfs(0, 0, &mut row, &mut col, &mut boxs, board);
    }
    fn dfs(
        mut i: usize,
        mut j: usize,
        row: &mut Vec<Vec<bool>>,
        col: &mut Vec<Vec<bool>>,
        boxs: &mut Vec<Vec<bool>>,
        board: &mut Vec<Vec<char>>,
    ) -> bool {
        while board[i][j] != '.' {
            j += 1;
            if j == 9 {
                i += 1;
                j = 0;
            }
            if i == 9 {
                return true;
            }
        }
        for num in 0..9 {
            if row[i][num] || col[j][num] || boxs[(i / 3) * 3 + j / 3][num] {
                continue;
            }
            row[i][num] = true;
            col[j][num] = true;
            boxs[(i / 3) * 3 + j / 3][num] = true;
            board[i][j] = (num + 1) as u8 as char;
            if Self::dfs(i, j, row, col, boxs, board) {
                return true;
            }
            row[i][num] = false;
            col[j][num] = false;
            boxs[(i / 3) * 3 + j / 3][num] = false;
        }
        board[i][j] = '.';
        false
    }
}