impl Solution {
    pub fn maximal_square(matrix: Vec<Vec<char>>) -> i32 {
        

        let m = matrix.len();
        if m == 0 {
            return 0;
        }
        let n = matrix[0].len();
        let mut dp = vec![vec![0; n + 1]; m + 1];
        let mut ans = 0;
        for i in 1..=m {
            for j in 1..=n {
                if matrix[i - 1][j - 1] == '1' {
                    dp[i][j] = 1 + dp[i - 1][j - 1].min(dp[i - 1][j].min(dp[i][j - 1]));
                    ans = ans.max(dp[i][j]);
                }
            }
        }
        ans * ans
    }
}