impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue: Vec<(usize, usize)> = vec![];
        queue.push((0, 0));
        let mut res = false;
        while !queue.is_empty() {
            let (i, j) = queue.remove(0);
            if i == m - 1 && j == n - 1 {
                res = true;
                break;
            }
            if !visited[i][j] {
                visited[i][j] = true;
                match grid[i][j] {
                    '/' => {
                        if i > 0 && grid[i - 1][j] == '/' {
                            queue.push((i - 1, j));
                        }
                        if j > 0 && grid[i][j - 1] == '/' {
                            queue.push((i, j - 1));
                        }
                        if i < m - 1 && grid[i + 1][j] == '\\' {
                            queue.push((i + 1, j));
                        }
                        if j < n - 1 && grid[i][j + 1] == '\\' {
                            queue.push((i, j + 1));
                        }
                    }
                    '\\' => {
                        if i > 0 && grid[i - 1][j] == '\\' {
                            queue.push((i - 1, j));
                        }
                        if j > 0 && grid[i][j - 1] == '\\' {
                            queue.push((i, j - 1));
                        }
                        if i < m - 1 && grid[i + 1][j] == '/' {
                            queue.push((i + 1, j));
                        }
                        if j < n - 1 && grid[i][j + 1] == '/' {
                            queue.push((i, j + 1));
                        }
                    }
                    '(' => {
                        if i > 0 && grid[i - 1][j] != ')' {
                            queue.push((i - 1, j));
                        }
                        if j > 0 && grid[i][j - 1] != ')' {
                            queue.push((i, j - 1));
                        }
                        if i < m - 1 && grid[i + 1][j] != ')' {
                            queue.push((i + 1,
    }
}