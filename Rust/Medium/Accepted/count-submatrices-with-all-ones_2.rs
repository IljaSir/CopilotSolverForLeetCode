impl Solution {
    pub fn num_submat(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![vec![0; mat[0].len()]; mat.len()];
        for i in 0..mat.len() {
            for j in 0..mat[0].len() {
                if mat[i][j] == 1 {
                    if j > 0 {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    let mut min = dp[i][j];
                    for k in (0..=i).rev() {
                        min = std::cmp::min(min, dp[k][j]);
                        res += min;
                    }
                }
            }
        }
        res
    }
}