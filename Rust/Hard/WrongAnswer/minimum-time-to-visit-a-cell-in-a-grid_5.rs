impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, 0, 0));
        visited[0][0] = true;
        let mut t = 0;
        while !q.is_empty() {
            let (i, j, tt) = q.pop_front().unwrap();
            if i == grid.len() - 1 && j == grid[0].len() - 1 {
                t = tt;
                break;
            }
            for (ii, jj) in vec![(i, j + 1), (i, j - 1), (i - 1, j), (i + 1, j)] {
                if ii >= 0 && ii < grid.len() && jj >= 0 && jj < grid[0].len() && !visited[ii][jj] {
                    if tt + 1 >= grid[ii][jj] {
                        q.push_back((ii, jj, tt + 1));
                        visited[ii][jj] = true;
                    } else {
                        q.push_back((ii, jj, grid[ii][jj]));
                        visited[ii][jj] = true;
                    }
                }
            }
        }
        if visited[grid.len() - 1][grid[0].len() - 1] {
            t
        } else {
            -1
        }
    }
}