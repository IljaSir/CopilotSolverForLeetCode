impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut q = std::collections::VecDeque::new();
        let mut visited = vec![vec![false; grid.len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                if grid[i][j] == 1 {
                    q.push_back((i, j));
                    visited[i][j] = true;
                }
            }
        }
        let mut ans = -1;
        while !q.is_empty() {
            let (i, j) = q.pop_front().unwrap();
            ans = ans.max(i as i32).max(j as i32).max((grid.len() - i - 1) as i32).max((grid.len() - j - 1) as i32);
            if i > 0 && !visited[i - 1][j] {
                q.push_back((i - 1, j));
                visited[i - 1][j] = true;
            }
            if j > 0 && !visited[i][j - 1] {
                q.push_back((i, j - 1));
                visited[i][j - 1] = true;
            }
            if i < grid.len() - 1 && !visited[i + 1][j] {
                q.push_back((i + 1, j));
                visited[i + 1][j] = true;
            }
            if j < grid.len() - 1 && !visited[i][j + 1] {
                q.push_back((i, j + 1));
                visited[i][j + 1] = true;
            }
        }
        ans
    }
}