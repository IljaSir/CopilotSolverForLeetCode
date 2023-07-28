impl Solution {
    pub fn max_dot_product(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let m = nums1.len();
        let n = nums2.len();
        let mut dp = vec![vec![std::i32::MIN; n + 1]; m + 1];
        for i in 1..=m {
            for j in 1..=n {
                dp[i][j] = dp[i - 1][j - 1].max(dp[i - 1][j].max(dp[i][j - 1]));
                dp[i][j] = dp[i][j].max(dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
            }
        }
        dp[m][n]
    }
}