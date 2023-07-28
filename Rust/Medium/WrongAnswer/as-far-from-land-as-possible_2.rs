impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut dist = vec![vec![n as i32 + 1; n]; n];
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] == 1 {
                    dist[i][j] = 0;
                } else {
                    if i > 0 {
                        dist[i][j] = dist[i][j].min(dist[i - 1][j] + 1);
                    }
                    if j > 0 {
                        dist[i][j] = dist[i][j].min(dist[i][j - 1] + 1);
                    }
                }
            }
        }
        for i in (0..n).rev() {
            for j in (0..n).rev() {
                if grid[i][j] == 0 {
                    if i + 1 < n {
                        dist[i][j] = dist[i][j].min(dist[i + 1][j] + 1);
                    }
                    if j + 1 < n {
                        dist[i][j] = dist[i][j].min(dist[i][j + 1] + 1);
                    }
                }
            }
        }
        let mut ans = -1;
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] == 0 {
                    ans = ans.max(dist[i][j]);
                }
            }
        }
        ans
    }
}