impl Solution {
    pub fn predict_the_winner(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = nums[i];
        }
        for i in (0..n).rev() {
            for j in (i + 1)..n {
                dp[i][j] = (nums[i] - dp[i + 1][j]).max(nums[j] - dp[i][j - 1]);
            }
        }
        dp[0][n - 1] >= 0
    }
}