impl Solution {
    pub fn snakes_and_ladders(board: Vec<Vec<i32>>) -> i32 {
        
        let n = board.len();
        let mut visited = vec![false; n * n];
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0));
        while let Some((step, pos)) = queue.pop_front() {
            if pos == n * n - 1 {
                return step;
            }
            for i in 1..=6 {
                let next_pos = pos + i;
                let (r, c) = Self::get_pos(next_pos, n);
                let next_pos = if board[r][c] == -1 {
                    next_pos
                } else {
                    board[r][c] as usize - 1
                };
                if !visited[next_pos] {
                    visited[next_pos] = true;
                    queue.push_back((step + 1, next_pos));
                }
            }
        }
        -1
    }

    fn get_pos(pos: usize, n: usize) -> (usize, usize) {
        let r = n - 1 - pos / n;
        let c = if r % 2 == n % 2 { pos % n } else { n - 1 - pos % n };
        (r, c)
    }
}