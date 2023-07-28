impl Solution {
    pub fn num_submat(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        let m = mat.len();
        let n = mat[0].len();
        let mut dp = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                if mat[i][j] == 1 {
                    dp[i][j] = 1;
                    if j > 0 {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                let mut width = dp[i][j];
                for k in i..m {
                    if dp[k][j] == 0 {
                        break;
                    }
                    width = width.min(dp[k][j]);
                    ans += width;
                }
            }
        }
        ans
    }
}