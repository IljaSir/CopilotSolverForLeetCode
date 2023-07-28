impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let n = grid.len();
        let mut queue = std::collections::VecDeque::new();
        let mut ans = -1;
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] == 1 {
                    queue.push_back((i, j));
                }
            }
        }
        if queue.len() == 0 || queue.len() == n * n {
            return ans;
        }
        while !queue.is_empty() {
            let (i, j) = queue.pop_front().unwrap();
            if i > 0 && grid[i - 1][j] == 0 {
                grid[i - 1][j] = grid[i][j] + 1;
                queue.push_back((i - 1, j));
            }
            if i < n - 1 && grid[i + 1][j] == 0 {
                grid[i + 1][j] = grid[i][j] + 1;
                queue.push_back((i + 1, j));
            }
            if j > 0 && grid[i][j - 1] == 0 {
                grid[i][j - 1] = grid[i][j] + 1;
                queue.push_back((i, j - 1));
            }
            if j < n - 1 && grid[i][j + 1] == 0 {
                grid[i][j + 1] = grid[i][j] + 1;
                queue.push_back((i, j + 1));
            }
            ans = ans.max(grid[i][j] - 1);
        }
        ans
    }
}