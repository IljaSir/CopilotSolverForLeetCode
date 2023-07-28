impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0));
        let mut found = false;
        while !queue.is_empty() {
            let (i, j) = queue.pop_front().unwrap();
            if visited[i][j] {
                continue;
            }
            visited[i][j] = true;
            if i == m - 1 && j == n - 1 {
                found = true;
                break;
            }
            let street = grid[i][j];
            if street == 1 {
                if j > 0 && grid[i][j - 1] == 1 {
                    queue.push_back((i, j - 1));
                }
                if j < n - 1 && grid[i][j + 1] == 1 {
                    queue.push_back((i, j + 1));
                }
            } else if street == 2 {
                if i > 0 && grid[i - 1][j] == 2 {
                    queue.push_back((i - 1, j));
                }
                if i < m - 1 && grid[i + 1][j] == 2 {
                    queue.push_back((i + 1, j));
                }
            } else if street == 3 {
                if j > 0 && grid[i][j - 1] == 1 {
                    queue.push_back((i, j - 1));
                }
                if i < m - 1 && grid[i + 1][j] == 2 {
                    queue.push_back((i + 1, j));
                }
            } else if street == 4 {
                if j < n - 1 && grid[i][j + 1] == 1 {
                    queue.push_back((i, j + 1));
                }
                if i < m - 1 && grid[i + 1][j] == 2 {
                    queue.push_back((i + 1, j));
                }
            } else if street == 5 {
                if j > 0 && grid[i][j - 1] == 1 {
                    queue.push_back((i, j - 1));
                }
                if i > 0 &&
    }
}