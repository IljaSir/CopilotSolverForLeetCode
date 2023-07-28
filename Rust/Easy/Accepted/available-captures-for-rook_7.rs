impl Solution {
    pub fn num_rook_captures(board: Vec<Vec<char>>) -> i32 {
        
        let mut row = 0;
        let mut col = 0;
        let mut count = 0;
        for i in 0..8 {
            for j in 0..8 {
                if board[i][j] == 'R' {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        for i in (0..row).rev() {
            if board[i][col] == 'p' {
                count += 1;
                break;
            } else if board[i][col] == 'B' {
                break;
            }
        }
        for i in (row + 1)..8 {
            if board[i][col] == 'p' {
                count += 1;
                break;
            } else if board[i][col] == 'B' {
                break;
            }
        }
        for i in (0..col).rev() {
            if board[row][i] == 'p' {
                count += 1;
                break;
            } else if board[row][i] == 'B' {
                break;
            }
        }
        for i in (col + 1)..8 {
            if board[row][i] == 'p' {
                count += 1;
                break;
            } else if board[row][i] == 'B' {
                break;
            }
        }
        count
    }
}