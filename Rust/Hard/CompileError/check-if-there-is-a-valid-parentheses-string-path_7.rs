impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        
        let mut dp = vec![vec![vec![false; 4]; grid[0].len()]; grid.len()];
        let mut q = Vec::new();
        q.push((0, 0, 0));
        q.push((0, 0, 1));
        q.push((0, 0, 2));
        q.push((0, 0, 3));
        while !q.is_empty() {
            let (x, y, d) = q.remove(0);
            if dp[x][y][d] {
                continue;
            }
            dp[x][y][d] = true;
            match (grid[x][y], d) {
                ('/', 0) => {
                    if x + 1 < grid.len() {
                        q.push((x + 1, y, 2));
                    }
                    if y + 1 < grid[0].len() {
                        q.push((x, y + 1, 3));
                    }
                }
                ('/', 1) => {
                    if x + 1 < grid.len() {
                        q.push((x + 1, y, 3));
                    }
                    if y > 0 {
                        q.push((x, y - 1, 2));
                    }
                }
                ('/', 2) => {
                    if x > 0 {
                        q.push((x - 1, y, 0));
                    }
                    if y + 1 < grid[0].len() {
                        q.push((x, y + 1, 1));
                    }
                }
                ('/', 3) => {
                    if x > 0 {
                        q.push((x - 1, y, 1));
                    }
                    if y > 0 {
                        q.push((x, y - 1, 0));
                    }
                }
                ('\\', 0) => {
                    if x + 1 < grid.len() {
                        q.push((x + 1, y, 3));
                    }
                    if y > 0 {
                        q.push((x, y - 1, 2));
                    }
                }
                ('\\', 1) => {
                    if x + 1 < grid.len() {
                        q.push((x + 1, y, 2));
                    }
                    if y + 1 < grid[0].len()
    }
}