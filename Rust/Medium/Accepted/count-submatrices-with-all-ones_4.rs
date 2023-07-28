impl Solution {
    pub fn num_submat(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        let n = mat.len();
        let m = mat[0].len();
        let mut dp = vec![vec![0; m]; n];
        for i in 0..n {
            for j in 0..m {
                if mat[i][j] == 1 {
                    dp[i][j] = 1;
                    if j > 0 {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        for i in 0..n {
            for j in 0..m {
                if mat[i][j] == 1 {
                    let mut min = dp[i][j];
                    for k in i..n {
                        if mat[k][j] == 0 {
                            break;
                        }
                        min = min.min(dp[k][j]);
                        ans += min;
                    }
                }
            }
        }
        ans
    }
}