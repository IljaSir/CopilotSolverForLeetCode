impl Solution {
    pub fn max_points(grid: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut prefix = vec![vec![0; n + 1]; m + 1];
        for i in 0..m {
            for j in 0..n {
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + if grid[i][j] > 0 { 1 } else { 0 };
            }
        }
        let mut res = Vec::new();
        for q in queries {
            let mut max = 0;
            for i in 0..m {
                for j in 0..n {
                    let mut l = 1;
                    let mut r = std::cmp::min(m - i, n - j);
                    let mut ans = 0;
                    while l <= r {
                        let mid = (l + r) / 2;
                        let cnt = prefix[i + mid][j + mid] - prefix[i + mid][j] - prefix[i][j + mid] + prefix[i][j];
                        if cnt as i32 >= q {
                            ans = mid;
                            r = mid - 1;
                        } else {
                            l = mid + 1;
                        }
                    }
                    max = std::cmp::max(max, ans);
                }
            }
            res.push(max as i32);
        }
        res
    }
}