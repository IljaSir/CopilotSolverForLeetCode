impl Solution {
    pub fn game_of_life(board: &mut Vec<Vec<i32>>) {
        

        let mut next = vec![vec![0; board[0].len()]; board.len()];
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                let mut count = 0;
                for k in -1..2 {
                    for l in -1..2 {
                        if k == 0 && l == 0 { continue; }
                        if i as i32 + k < 0 || i as i32 + k >= board.len() as i32 { continue; }
                        if j as i32 + l < 0 || j as i32 + l >= board[0].len() as i32 { continue; }
                        if board[(i as i32 + k) as usize][(j as i32 + l) as usize] == 1 { count += 1; }
                    }
                }
                if board[i][j] == 1 {
                    if count < 2 || count > 3 { next[i][j] = 0; }
                    else { next[i][j] = 1; }
                } else {
                    if count == 3 { next[i][j] = 1; }
                    else { next[i][j] = 0; }
                }
            }
        }
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                board[i][j] = next[i][j];
            }
        }