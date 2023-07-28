impl Solution {
    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        

        let mut row = vec![vec![0; 9]; 9];
        let mut col = vec![vec![0; 9]; 9];
        let mut boxs = vec![vec![0; 9]; 9];
        for i in 0..9 {
            for j in 0..9 {
                if board[i][j] != '.' {
                    let num = board[i][j] as usize - '1' as usize;
                    let box_index = (i / 3) * 3 + j / 3;
                    row[i][num] += 1;
                    col[j][num] += 1;
                    boxs[box_index][num] += 1;
                    if row[i][num] > 1 || col[j][num] > 1 || boxs[box_index][num] > 1 {
                        return false;
                    }
                }
            }
        }
        true
    }
}