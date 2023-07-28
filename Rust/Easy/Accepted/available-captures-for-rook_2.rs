impl Solution {
    pub fn num_rook_captures(board: Vec<Vec<char>>) -> i32 {
        
        let mut x = 0;
        let mut y = 0;
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
            if board[i][y] == 'B' {
                break;
            }
            if board[i][y] == 'p' {
                res += 1;
                break;
            }
        }
        for i in (x+1)..8 {
            if board[i][y] == 'B' {
                break;
            }
            if board[i][y] == 'p' {
                res += 1;
                break;
            }
        }
        for j in (0..y).rev() {
            if board[x][j] == 'B' {
                break;
            }
            if board[x][j] == 'p' {
                res += 1;
                break;
            }
        }
        for j in (y+1)..8 {
            if board[x][j] == 'B' {
                break;
            }
            if board[x][j] == 'p' {
                res += 1;
                break;
            }
        }
        res
    }
}