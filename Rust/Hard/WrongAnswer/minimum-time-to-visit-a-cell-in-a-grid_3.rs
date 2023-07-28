impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![std::i32::MAX; n]; m];
        let mut q = std::collections::BinaryHeap::new();
        q.push(std::cmp::Reverse((0, 0, 0)));
        let mut ans = -1;
        while !q.is_empty() {
            let (t, x, y) = q.pop().unwrap().0;
            if t >= dp[x][y] {
                continue;
            }
            dp[x][y] = t;
            if x == m - 1 && y == n - 1 {
                ans = t;
                break;
            }
            if x > 0 {
                q.push(std::cmp::Reverse((std::cmp::max(t, grid[x - 1][y]), x - 1, y)));
            }
            if x + 1 < m {
                q.push(std::cmp::Reverse((std::cmp::max(t, grid[x + 1][y]), x + 1, y)));
            }
            if y > 0 {
                q.push(std::cmp::Reverse((std::cmp::max(t, grid[x][y - 1]), x, y - 1)));
            }
            if y + 1 < n {
                q.push(std::cmp::Reverse((std::cmp::max(t, grid[x][y + 1]), x, y + 1)));
            }
        }
        ans
    }
}