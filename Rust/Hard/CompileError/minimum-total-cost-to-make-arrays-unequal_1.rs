impl Solution {
    pub fn minimum_total_cost(nums1: Vec<i32>, nums2: Vec<i32>) -> i64 {
        
        let n = nums1.len();
        let mut dp = vec![vec![std::i64::MAX; 3]; n];
        for i in 0..n {
            let a = nums1[i];
            let b = nums2[i];
            if a == b {
                dp[i][0] = 0;
                dp[i][1] = 0;
                dp[i][2] = 0;
            } else {
                dp[i][0] = 0;
                dp[i][1] = a as i64;
                dp[i][2] = b as i64;
            }
            if i > 0 {
                if nums1[i] != nums1[i - 1] {
                    dp[i][0] = dp[i][0].min(dp[i - 1][0]);
                    dp[i][1] = dp[i][1].min(dp[i - 1][0] + a as i64);
                    dp[i][2] = dp[i][2].min(dp[i - 1][0] + b as i64);
                }
                if nums1[i] != nums2[i - 1] {
                    dp[i][0] = dp[i][0].min(dp[i - 1][1]);
                    dp[i][1] = dp[i][1].min(dp[i - 1][1] + a as i64);
                    dp[i][2] = dp[i][2].min(dp[i - 1][1] + b as i64);
                }
                if nums2[i] != nums1[i - 1] {
                    dp[i][0] = dp[i][0].min(dp[i - 1][2]);
                    dp[i][1] = dp[i][1].min(dp[i - 1][2] + a as i64);
                    dp[i][2] = dp[i][2].min(dp[i - 1][2] + b as i64);
                }
                if nums2[i] != nums2[i - 1] {
                    dp[i][0] = dp[i][0].min(dp[i - 1][2]);
                    dp[i][1] = dp[i][1].min(dp[i - 1][2] + a as i64);
                    dp[i][2] = dp[i][2].min(dp[i - 1][2] + b
    }
}