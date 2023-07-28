impl Solution {
    pub fn min_swap(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let n = nums1.len();
        let mut dp = vec![vec![std::i32::MAX; 2]; n];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for i in 1..n {
            if nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1] {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1] + 1;
            }
            if nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1] {
                dp[i][0] = dp[i][0].min(dp[i-1][1]);
                dp[i][1] = dp[i][1].min(dp[i-1][0] + 1);
            }
        }
        dp[n-1][0].min(dp[n-1][1])
    }
}