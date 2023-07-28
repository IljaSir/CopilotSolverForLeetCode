impl Solution {
    pub fn minimum_xor_sum(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let n = nums1.len();
        let mut dp = vec![vec![0; 1 << n]; n];
        for i in 0..n {
            for j in 0..(1 << n) {
                let mut min = i32::MAX;
                for k in 0..n {
                    if j & (1 << k) == 0 {
                        let val = dp[i][j];
                        let new_val = if i == 0 {
                            val
                        } else {
                            val.min(dp[i - 1][j | (1 << k)])
                        };
                        min = min.min(new_val + (nums1[i] ^ nums2[k]));
                    }
                }
                dp[i][j] = min;
            }
        }
        dp[n - 1][0]
    }
}