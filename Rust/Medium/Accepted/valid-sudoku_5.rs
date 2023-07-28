impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        

        let mut row = vec![vec![0; 9]; 9];
        let mut col = vec![vec![0; 9]; 9];
        let mut block = vec![vec![0; 9]; 9];
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] == '.' {
                    continue;
                }
                let num = (board[i][j] as u8 - b'1') as usize;
                let k = i / 3 * 3 + j / 3;
                row[i][num] += 1;
                col[j][num] += 1;
                block[k][num] += 1;
                if row[i][num] > 1 || col[j][num] > 1 || block[k][num] > 1 {
                    return false;
                }
            }
        }
        true
    }
}