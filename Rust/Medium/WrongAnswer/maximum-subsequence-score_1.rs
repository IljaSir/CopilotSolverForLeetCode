impl Solution {
    pub fn max_score(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
        
        let n = nums1.len();
        let mut ans = 0;
        let mut left = 0;
        let mut right = 0;
        let mut min = std::i32::MAX;
        let mut max = std::i32::MIN;
        for i in 0..n {
            min = min.min(nums1[i].min(nums2[i]));
            max = max.max(nums1[i].max(nums2[i]));
        }
        let mut dp = vec![vec![0i64; n + 1]; k as usize + 1];
        for i in 1..=k {
            let mut max = std::i64::MIN;
            for j in 0..=n {
                if j > 0 {
                    dp[i as usize][j as usize] = dp[i as usize][j as usize - 1].max(dp[i as usize - 1][j as usize - 1] + nums1[j - 1].min(nums2[j - 1]) as i64);
                    max = max.max(dp[i as usize][j as usize]);
                }
                if j < n {
                    dp[i as usize][j as usize] = max.max(dp[i as usize - 1][j as usize] + nums1[j].min(nums2[j]) as i64);
                }
            }
        }
        dp[k as usize][n as usize]
    }
}