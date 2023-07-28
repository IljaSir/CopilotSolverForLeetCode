impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        

        let mut rows = vec![vec![0; 9]; 9];
        let mut cols = vec![vec![0; 9]; 9];
        let mut blocks = vec![vec![0; 9]; 9];
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] == '.' {
                    continue;
                }
                let num = board[i][j].to_digit(10).unwrap() as usize - 1;
                let block_index = i / 3 * 3 + j / 3;
                rows[i][num] += 1;
                cols[j][num] += 1;
                blocks[block_index][num] += 1;
                if rows[i][num] > 1 || cols[j][num] > 1 || blocks[block_index][num] > 1 {
                    return false;
                }
            }
        }
        true
    }
}