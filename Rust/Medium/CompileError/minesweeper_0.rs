impl Solution {
    pub fn update_board(board: Vec<Vec<char>>, click: Vec<i32>) -> Vec<Vec<char>> {
        

        let mut board = board;
        let (r, c) = (click[0] as usize, click[1] as usize);
        if board[r][c] == 'M' {
            board[r][c] = 'X';
            board
        } else {
            let m = board.len();
            let n = board[0].len();
            let mut stack = vec![(r, c)];
            let mut visited = vec![vec![false; n]; m];
            while let Some((r, c)) = stack.pop() {
                if visited[r][c] {
                    continue;
                }
                visited[r][c] = true;
                let mut cnt = 0;
                for (i, j) in &[(r as i32 - 1, c as i32 - 1), (r as i32 - 1, c as i32), (r as i32 - 1, c as i32 + 1), (r as i32, c as i32 - 1), (r as i32, c as i32 + 1), (r as i32 + 1, c as i32 - 1), (r as i32 + 1, c as i32), (r as i32 + 1, c as i32 + 1)] {
                    if i < 0 || i >= m as i32 || j < 0 || j >= n as i32 {
                        continue;
                    }
                    if board[i as usize][j as usize] == 'M' {
                        cnt += 1;
                    }
                }
                if cnt > 0 {
                    board[r][c] = (cnt as u8 + b'0') as char;
                } else {
                    board[r][c] = 'B';
                    for (i, j) in &[(r as i32 - 1, c as i32 - 1), (r as i32 - 1, c as i32), (r as i32 - 1, c as i32 + 1), (r as i32, c as i32 - 1), (r as i32, c as i32 + 1), (r as i32 + 1, c as i32 - 1), (r as i32 + 1, c as i32), (r as i
    }
}