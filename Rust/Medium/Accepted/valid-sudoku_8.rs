impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        

        let mut rows = vec![0; 9];
        let mut cols = vec![0; 9];
        let mut blocks = vec![0; 9];
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] != '.' {
                    let value = 1 << (board[i][j] as u8 - '1' as u8);
                    let block = i / 3 * 3 + j / 3;
                    if value & rows[i] > 0 || value & cols[j] > 0 || value & blocks[block] > 0 {
                        return false;
                    }
                    rows[i] |= value;
                    cols[j] |= value;
                    blocks[block] |= value;
                }
            }
        }
        true
    }
}