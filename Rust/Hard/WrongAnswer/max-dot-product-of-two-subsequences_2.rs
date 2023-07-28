impl Solution {
    pub fn max_dot_product(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let (n1, n2) = (nums1.len(), nums2.len());
        let mut dp = vec![vec![0; n2]; n1];
        dp[0][0] = nums1[0] * nums2[0];
        for i in 1..n1 {
            dp[i][0] = dp[i - 1][0].max(nums1[i] * nums2[0]);
        }
        for j in 1..n2 {
            dp[0][j] = dp[0][j - 1].max(nums1[0] * nums2[j]);
        }
        for i in 1..n1 {
            for j in 1..n2 {
                dp[i][j] = dp[i - 1][j - 1].max(dp[i - 1][j]).max(dp[i][j - 1]);
                dp[i][j] = dp[i][j].max(dp[i - 1][j - 1] + nums1[i] * nums2[j]);
            }
        }
        dp[n1 - 1][n2 - 1]
    }
}