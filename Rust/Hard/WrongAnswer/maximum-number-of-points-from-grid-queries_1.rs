impl Solution {
    pub fn max_points(grid: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut prefix = vec![vec![0; n + 1]; m + 1];
        for i in 0..m {
            for j in 0..n {
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + (grid[i][j] as i64);
            }
        }
        let mut result = vec![0; queries.len()];
        for i in 0..queries.len() {
            let mut max = 0;
            for j in 0..m {
                for k in 0..n {
                    if grid[j][k] > queries[i] {
                        continue;
                    }
                    let mut l = 0;
                    let mut r = m.min(n) as i32;
                    while l < r {
                        let mid = (l + r + 1) / 2;
                        let x = (j as i32 + mid).min(m as i32);
                        let y = (k as i32 + mid).min(n as i32);
                        let sum = prefix[x as usize][y as usize] - prefix[x as usize][k as usize] - prefix[j as usize][y as usize] + prefix[j as usize][k as usize];
                        if sum == (mid * 2 + 1).pow(2) as i64 {
                            l = mid;
                        } else {
                            r = mid - 1;
                        }
                    }
                    max = max.max(l);
                }
            }
            result[i] = max;
        }
        result
    }
}