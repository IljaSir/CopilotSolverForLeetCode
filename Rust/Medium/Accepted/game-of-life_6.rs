impl Solution {
    pub fn game_of_life(board: &mut Vec<Vec<i32>>) {
        

        let mut copy = board.clone();
        for i in 0..board.len() {
            for j in 0..board[i].len() {
                let mut count = 0;
                for x in -1..=1 {
                    for y in -1..=1 {
                        if x == 0 && y == 0 {
                            continue;
                        }
                        if i as i32 + x < 0 || i as i32 + x >= board.len() as i32 ||
                            j as i32 + y < 0 || j as i32 + y >= board[i].len() as i32 {
                            continue;
                        }
                        if board[(i as i32 + x) as usize][(j as i32 + y) as usize] == 1 {
                            count += 1;
                        }
                    }
                }
                if board[i][j] == 1 {
                    if count < 2 {
                        copy[i][j] = 0;
                    }
                    if count == 2 || count == 3 {
                        copy[i][j] = 1;
                    }
                    if count > 3 {
                        copy[i][j] = 0;
                    }
                } else {
                    if count == 3 {
                        copy[i][j] = 1;
                    }
                }
            }
        }
        *board = copy;
    }
}