impl Solution {
    pub fn update_board(board: Vec<Vec<char>>, click: Vec<i32>) -> Vec<Vec<char>> {
        

        let mut board = board;
        let (row, col) = (click[0] as usize, click[1] as usize);
        let (m, n) = (board.len(), board[0].len());
        if board[row][col] == 'M' {
            board[row][col] = 'X';
        } else {
            let mut stack = vec![(row, col)];
            while let Some((row, col)) = stack.pop() {
                let mut count = 0;
                for i in (row as i32 - 1).max(0) as usize..=(row as i32 + 1).min(m as i32 - 1) as usize {
                    for j in (col as i32 - 1).max(0) as usize..=(col as i32 + 1).min(n as i32 - 1) as usize {
                        if board[i][j] == 'M' {
                            count += 1;
                        }
                    }
                }
                if count > 0 {
                    board[row][col] = (count as u8 + b'0') as char;
                } else {
                    board[row][col] = 'B';
                    for i in (row as i32 - 1).max(0) as usize..=(row as i32 + 1).min(m as i32 - 1) as usize {
                        for j in (col as i32 - 1).max(0) as usize..=(col as i32 + 1).min(n as i32 - 1) as usize {
                            if board[i][j] == 'E' {
                                stack.push((i, j));
                                board[i][j] = 'B';
                            }
                        }
                    }
                }
            }
        }
        board
    }
}