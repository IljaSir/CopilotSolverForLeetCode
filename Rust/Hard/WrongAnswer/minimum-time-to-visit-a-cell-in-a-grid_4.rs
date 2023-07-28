impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut q = std::collections::BinaryHeap::new();
        let mut visited = vec![vec![false; n]; m];
        let mut res = 0;
        q.push(std::cmp::Reverse((0, 0, 0)));
        while !q.is_empty() {
            let (t, x, y) = q.pop().unwrap().0;
            if x == m - 1 && y == n - 1 {
                res = t;
                break;
            }
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            if x > 0 {
                q.push(std::cmp::Reverse((std::cmp::max(t, grid[x][y]), x - 1, y)));
            }
            if x < m - 1 {
                q.push(std::cmp::Reverse((std::cmp::max(t, grid[x][y]), x + 1, y)));
            }
            if y > 0 {
                q.push(std::cmp::Reverse((std::cmp::max(t, grid[x][y]), x, y - 1)));
            }
            if y < n - 1 {
                q.push(std::cmp::Reverse((std::cmp::max(t, grid[x][y]), x, y + 1)));
            }
        }
        if visited[m - 1][n - 1] {
            res
        } else {
            -1
        }
    }
}