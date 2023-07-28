impl Solution {
    pub fn max_points(grid: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut prefix = vec![vec![0; n + 1]; m + 1];
        for i in 0..m {
            for j in 0..n {
                prefix[i + 1][j + 1] = grid[i][j] + prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j];
            }
        }
        let mut res = vec![];
        for &q in &queries {
            let mut max = 0;
            for i in 0..m {
                for j in 0..n {
                    let mut l = 0;
                    let mut r = std::cmp::min(m - i, n - j) as i32;
                    while l < r {
                        let mid = (l + r + 1) / 2;
                        let sum = prefix[i + mid as usize][j + mid as usize]
                            - prefix[i][j + mid as usize]
                            - prefix[i + mid as usize][j]
                            + prefix[i][j];
                        if sum <= q {
                            l = mid;
                        } else {
                            r = mid - 1;
                        }
                    }
                    max = std::cmp::max(max, l);
                }
            }
            res.push(max);
        }
        res
    }
}