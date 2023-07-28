impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0));
        while !queue.is_empty() {
            let (x, y) = queue.pop_front().unwrap();
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            if x == m - 1 && y == n - 1 {
                return true;
            }
            match grid[x][y] {
                1 => {
                    if y > 0 && grid[x][y - 1] == 1 {
                        queue.push_back((x, y - 1));
                    }
                    if y + 1 < n && grid[x][y + 1] == 1 {
                        queue.push_back((x, y + 1));
                    }
                }
                2 => {
                    if x > 0 && grid[x - 1][y] == 2 {
                        queue.push_back((x - 1, y));
                    }
                    if x + 1 < m && grid[x + 1][y] == 2 {
                        queue.push_back((x + 1, y));
                    }
                }
                3 => {
                    if y > 0 && grid[x][y - 1] == 1 {
                        queue.push_back((x, y - 1));
                    }
                    if x + 1 < m && grid[x + 1][y] == 2 {
                        queue.push_back((x + 1, y));
                    }
                }
                4 => {
                    if y + 1 < n && grid[x][y + 1] == 1 {
                        queue.push_back((x, y + 1));
                    }
                    if x + 1 < m && grid[x + 1][y] == 2 {
                        queue.push_back((x + 1, y));
                    }
                }
                5 => {
                    if y > 0 && grid[x][y - 1] == 1 {
                        queue.push_back((x, y - 1));
                    }
                    if x > 0 && grid[x - 1][y] == 2 {
                        queue.push_back((x - 1,
    }
}