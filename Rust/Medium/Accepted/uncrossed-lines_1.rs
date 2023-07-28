impl Solution {
    pub fn max_uncrossed_lines(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let (n1, n2) = (nums1.len(), nums2.len());
        let (mut dp, mut dp1) = (vec![0; n2 + 1], vec![0; n2 + 1]);
        for i in 1..=n1 {
            for j in 1..=n2 {
                if nums1[i - 1] == nums2[j - 1] {
                    dp[j] = dp1[j - 1] + 1;
                } else {
                    dp[j] = dp[j - 1].max(dp1[j]);
                }
            }
            dp1 = dp.clone();
        }
        dp[n2]
    }
}