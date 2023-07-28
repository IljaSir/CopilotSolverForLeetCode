impl Solution {
    pub fn num_rook_captures(board: Vec<Vec<char>>) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        for (index, row) in board.iter().enumerate() {
            if let Some(index) = row.iter().position(|&x| x == 'R') {
                i = index;
                j = index;
            }
        }
        for x in (0..i).rev() {
            if board[j][x] == 'B' {
                break;
            }
            if board[j][x] == 'p' {
                count += 1;
                break;
            }
        }
        for x in (i + 1)..board.len() {
            if board[j][x] == 'B' {
                break;
            }
            if board[j][x] == 'p' {
                count += 1;
                break;
            }
        }
        for y in (0..j).rev() {
            if board[y][i] == 'B' {
                break;
            }
            if board[y][i] == 'p' {
                count += 1;
                break;
            }
        }
        for y in (j + 1)..board.len() {
            if board[y][i] == 'B' {
                break;
            }
            if board[y][i] == 'p' {
                count += 1;
                break;
            }
        }
        count
    }
}