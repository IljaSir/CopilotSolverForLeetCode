impl Solution {
    pub fn update_board(board: Vec<Vec<char>>, click: Vec<i32>) -> Vec<Vec<char>> {
        

        let m = board.len();
        let n = board[0].len();
        let mut board = board;
        let mut queue = std::collections::VecDeque::new();
        let mut visited = std::collections::HashSet::new();
        queue.push_back((click[0] as usize, click[1] as usize));
        while !queue.is_empty() {
            let (i, j) = queue.pop_front().unwrap();
            if visited.contains(&(i, j)) {
                continue;
            }
            visited.insert((i, j));
            if board[i][j] == 'M' {
                board[i][j] = 'X';
            } else if board[i][j] == 'E' {
                let mut adj_mine_count = 0;
                for x in i.saturating_sub(1)..=(i + 1).min(m - 1) {
                    for y in j.saturating_sub(1)..=(j + 1).min(n - 1) {
                        if x == i && y == j {
                            continue;
                        }
                        if board[x][y] == 'M' {
                            adj_mine_count += 1;
                        }
                    }
                }
                if adj_mine_count == 0 {
                    board[i][j] = 'B';
                    for x in i.saturating_sub(1)..=(i + 1).min(m - 1) {
                        for y in j.saturating_sub(1)..=(j + 1).min(n - 1) {
                            if x == i && y == j {
                                continue;
                            }
                            queue.push_back((x, y));
                        }
                    }
                } else {
                    board[i][j] = (adj_mine_count as u8 + b'0') as char;
                }
            }
        }
        board
    }
}