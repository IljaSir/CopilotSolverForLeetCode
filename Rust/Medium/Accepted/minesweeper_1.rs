impl Solution {
    pub fn update_board(board: Vec<Vec<char>>, click: Vec<i32>) -> Vec<Vec<char>> {
        

        let mut board = board;
        let (clickr, clickc) = (click[0] as usize, click[1] as usize);
        if board[clickr][clickc] == 'M' {
            board[clickr][clickc] = 'X';
        } else {
            let mut stack = vec![(clickr, clickc)];
            while let Some((r, c)) = stack.pop() {
                let mut cnt = 0;
                for dr in -1..=1 {
                    for dc in -1..=1 {
                        if dr == 0 && dc == 0 {
                            continue;
                        }
                        let (nr, nc) = (r as i32 + dr, c as i32 + dc);
                        if nr < 0 || nr >= board.len() as i32 || nc < 0 || nc >= board[0].len() as i32 {
                            continue;
                        }
                        let (nr, nc) = (nr as usize, nc as usize);
                        if board[nr][nc] == 'M' {
                            cnt += 1;
                        }
                    }
                }
                if cnt == 0 {
                    board[r][c] = 'B';
                    for dr in -1..=1 {
                        for dc in -1..=1 {
                            if dr == 0 && dc == 0 {
                                continue;
                            }
                            let (nr, nc) = (r as i32 + dr, c as i32 + dc);
                            if nr < 0 || nr >= board.len() as i32 || nc < 0 || nc >= board[0].len() as i32 {
                                continue;
                            }
                            let (nr, nc) = (nr as usize, nc as usize);
                            if board[nr][nc] == 'E' {
                                stack.push((nr, nc));
                                board[nr][nc] = 'B';
                            }
                        }
                    }
                } else {
                    board[r][c] = (cnt as u8 + b'0') as char;
                }
            }
        }
        board
    }
}