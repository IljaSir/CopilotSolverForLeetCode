impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut stack = vec![(0, 0)];
        while let Some((x, y)) = stack.pop() {
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            if x == m - 1 && y == n - 1 {
                return true;
            }
            let dir = grid[x][y];
            if dir == 1 {
                if y > 0 && grid[x][y - 1] % 2 == 1 {
                    stack.push((x, y - 1));
                }
                if y < n - 1 && grid[x][y + 1] % 2 == 1 {
                    stack.push((x, y + 1));
                }
            } else if dir == 2 {
                if x > 0 && grid[x - 1][y] > 2 {
                    stack.push((x - 1, y));
                }
                if x < m - 1 && grid[x + 1][y] > 2 {
                    stack.push((x + 1, y));
                }
            } else if dir == 3 {
                if y > 0 && grid[x][y - 1] % 2 == 1 {
                    stack.push((x, y - 1));
                }
                if x < m - 1 && grid[x + 1][y] > 2 {
                    stack.push((x + 1, y));
                }
            } else if dir == 4 {
                if y < n - 1 && grid[x][y + 1] % 2 == 1 {
                    stack.push((x, y + 1));
                }
                if x < m - 1 && grid[x + 1][y] > 2 {
                    stack.push((x + 1, y));
                }
            } else if dir == 5 {
                if y > 0 && grid[x][y - 1] % 2 == 1 {
                    stack.push((x, y - 1));
                }
                if x > 0 && grid[x - 1][y] > 2 {
                    stack.push((x - 1, y));
    }
}