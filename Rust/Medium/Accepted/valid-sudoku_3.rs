impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        

        let mut row = vec![vec![false; 9]; 9];
        let mut col = vec![vec![false; 9]; 9];
        let mut boxs = vec![vec![false; 9]; 9];
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] == '.' {
                    continue;
                }
                let num = board[i][j] as usize - '0' as usize - 1;
                let k = i / 3 * 3 + j / 3;
                if row[i][num] || col[j][num] || boxs[k][num] {
                    return false;
                }
                row[i][num] = true;
                col[j][num] = true;
                boxs[k][num] = true;
            }
        }
        true
    }
}