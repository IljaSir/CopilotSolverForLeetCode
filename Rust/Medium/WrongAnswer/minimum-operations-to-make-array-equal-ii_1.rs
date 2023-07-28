impl Solution {
    pub fn min_operations(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> i64 {
        
        let k = k as usize;
        let (n1, n2) = (nums1.len(), nums2.len());
        if n1 > n2 {
            return Self::min_operations(nums2, nums1, k as i32) as i64;
        }
        let (sum1, sum2) = (nums1.iter().sum::<i32>(), nums2.iter().sum::<i32>());
        if sum1 > sum2 {
            return Self::min_operations(nums2, nums1, k as i32) as i64;
        }
        let (diff, mut dp) = (sum2 - sum1, vec![vec![0; k + 1]; n1 + 1]);
        let (mut i, mut j) = (0, 0);
        while i < n1 {
            let mut j = 0;
            while j <= k {
                if j > 0 {
                    dp[i + 1][j] = dp[i + 1][j].max(dp[i][j - 1]);
                }
                if j < k {
                    dp[i + 1][j + 1] = dp[i + 1][j + 1].max(dp[i][j] + (nums1[i] as i32 - nums2[j] as i32).abs());
                }
                j += 1;
            }
            i += 1;
        }
        dp[n1][k] as i64
    }
}