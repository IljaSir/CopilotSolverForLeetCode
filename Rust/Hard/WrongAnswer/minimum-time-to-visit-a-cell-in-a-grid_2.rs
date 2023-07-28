impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut queue = std::collections::BinaryHeap::new();
        let mut visited = vec![vec![false; n]; m];
        queue.push(std::cmp::Reverse((0, 0, 0)));
        while let Some(std::cmp::Reverse((t, x, y))) = queue.pop() {
            if x == m - 1 && y == n - 1 {
                return t;
            }
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            if x > 0 {
                queue.push(std::cmp::Reverse((t.max(grid[x][y]), x - 1, y)));
            }
            if x < m - 1 {
                queue.push(std::cmp::Reverse((t.max(grid[x][y]), x + 1, y)));
            }
            if y > 0 {
                queue.push(std::cmp::Reverse((t.max(grid[x][y]), x, y - 1)));
            }
            if y < n - 1 {
                queue.push(std::cmp::Reverse((t.max(grid[x][y]), x, y + 1)));
            }
        }
        -1
    }
}