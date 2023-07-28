impl Solution {
    pub fn num_rook_captures(board: Vec<Vec<char>>) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        for x in 0..8 {
            for y in 0..8 {
                if board[x][y] == 'R' {
                    i = x;
                    j = y;
                }
            }
        }
        let mut k = i;
        while k > 0 {
            k -= 1;
            if board[k][j] == 'p' {
                count += 1;
                break;
            } else if board[k][j] == 'B' {
                break;
            }
        }
        k = i;
        while k < 7 {
            k += 1;
            if board[k][j] == 'p' {
                count += 1;
                break;
            } else if board[k][j] == 'B' {
                break;
            }
        }
        k = j;
        while k > 0 {
            k -= 1;
            if board[i][k] == 'p' {
                count += 1;
                break;
            } else if board[i][k] == 'B' {
                break;
            }
        }
        k = j;
        while k < 7 {
            k += 1;
            if board[i][k] == 'p' {
                count += 1;
                break;
            } else if board[i][k] == 'B' {
                break;
            }
        }
        count
    }
}