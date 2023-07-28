impl Solution {
    pub fn update_board(board: Vec<Vec<char>>, click: Vec<i32>) -> Vec<Vec<char>> {
        

        let mut board = board;
        let (row, col) = (click[0] as usize, click[1] as usize);
        if board[row][col] == 'M' {
            board[row][col] = 'X';
        } else {
            let mut queue = Vec::new();
            queue.push((row, col));
            while !queue.is_empty() {
                let (r, c) = queue.pop().unwrap();
                let mut count = 0;
                for x in -1..=1 {
                    for y in -1..=1 {
                        if x == 0 && y == 0 {
                            continue;
                        }
                        let (r, c) = (r as i32 + x, c as i32 + y);
                        if r >= 0 && c >= 0 && r < board.len() as i32 && c < board[0].len() as i32 {
                            let (r, c) = (r as usize, c as usize);
                            if board[r][c] == 'M' {
                                count += 1;
                            }
                        }
                    }
                }
                if count > 0 {
                    board[r][c] = (count + b'0') as char;
                } else {
                    board[r][c] = 'B';
                    for x in -1..=1 {
                        for y in -1..=1 {
                            if x == 0 && y == 0 {
                                continue;
                            }
                            let (r, c) = (r as i32 + x, c as i32 + y);
                            if r >= 0 && c >= 0 && r < board.len() as i32 && c < board[0].len() as i32 {
                                let (r, c) = (r as usize, c as usize);
                                if board[r][c] == 'E' {
                                    queue.push((r, c));
                                    board[r][c] = 'B';
                                }
                            }
                        }
                    }
                }
            }
        }
        board
    }
}