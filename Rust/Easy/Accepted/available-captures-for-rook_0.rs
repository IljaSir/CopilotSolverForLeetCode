impl Solution {
    pub fn num_rook_captures(board: Vec<Vec<char>>) -> i32 {
        
        let (mut x, mut y) = (0, 0);
        for i in 0..8 {
            for j in 0..8 {
                if board[i][j] == 'R' {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        let mut res = 0;
        for i in (0..x).rev() {
            if board[i][y] == 'p' {
                res += 1;
                break;
            } else if board[i][y] == 'B' {
                break;
            }
        }
        for i in x+1..8 {
            if board[i][y] == 'p' {
                res += 1;
                break;
            } else if board[i][y] == 'B' {
                break;
            }
        }
        for i in (0..y).rev() {
            if board[x][i] == 'p' {
                res += 1;
                break;
            } else if board[x][i] == 'B' {
                break;
            }
        }
        for i in y+1..8 {
            if board[x][i] == 'p' {
                res += 1;
                break;
            } else if board[x][i] == 'B' {
                break;
            }
        }
        res
    }
}