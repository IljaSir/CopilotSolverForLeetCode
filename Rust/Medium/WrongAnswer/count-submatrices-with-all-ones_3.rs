impl Solution {
    pub fn num_submat(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![vec![0; mat[0].len()]; mat.len()];
        let mut res = 0;
        for i in 0..mat.len() {
            for j in 0..mat[0].len() {
                if mat[i][j] == 0 {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = if i == 0 {1} else {dp[i-1][j] + 1};
                }
                let mut min = dp[i][j];
                for k in j..mat[0].len() {
                    min = std::cmp::min(min, dp[i][k]);
                    res += min;
                }
            }
        }
        res
    }
}