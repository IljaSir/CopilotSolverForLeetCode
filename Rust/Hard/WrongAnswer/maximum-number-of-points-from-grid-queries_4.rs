impl Solution {
    pub fn max_points(grid: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut prefix = vec![vec![0; n + 1]; m + 1];
        for i in 1..=m {
            for j in 1..=n {
                prefix[i][j] = grid[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        let mut res = vec![];
        for q in queries {
            let mut max = 0;
            for i in 1..=m {
                for j in 1..=n {
                    for x in i..=m {
                        for y in j..=n {
                            if prefix[x][y] - prefix[i - 1][y] - prefix[x][j - 1] + prefix[i - 1][j - 1] <= q {
                                max = max.max((x - i + 1) * (y - j + 1));
                            }
                        }
                    }
                }
            }
            res.push(max as i32);
        }
        res
    }
}