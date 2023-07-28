impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0));
        while !queue.is_empty() {
            let (x, y) = queue.pop_front().unwrap();
            if x == grid.len() - 1 && y == grid[0].len() - 1 {
                return true;
            }
            visited[x][y] = true;
            for (nx, ny) in Self::next(x, y, grid[x][y]) {
                if !visited[nx][ny] && Self::check(nx, ny, grid[nx][ny], x, y, grid[x][y]) {
                    queue.push_back((nx, ny));
                }
            }
        }
        false
    }
    fn next(x: usize, y: usize, dir: i32) -> Vec<(usize, usize)> {
        match dir {
            1 => vec![(x, y - 1), (x, y + 1)],
            2 => vec![(x - 1, y), (x + 1, y)],
            3 => vec![(x, y - 1), (x + 1, y)],
            4 => vec![(x, y + 1), (x + 1, y)],
            5 => vec![(x, y - 1), (x - 1, y)],
            6 => vec![(x, y + 1), (x - 1, y)],
            _ => vec![],
        }
    }
}