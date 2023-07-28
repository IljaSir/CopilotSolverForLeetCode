impl Solution {
    pub fn minimum_xor_sum(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let n = nums1.len();
        let mut dp = vec![vec![0; n]; 1 << n];
        for i in 0..(1 << n) {
            for j in 0..n {
                if i & (1 << j) != 0 {
                    continue;
                }
                for k in 0..n {
                    if i & (1 << k) != 0 {
                        continue;
                    }
                    dp[i | (1 << k)][k] = std::cmp::max(dp[i | (1 << k)][k], dp[i][j] + (nums1[j] ^ nums2[k]));
                }
            }
        }
        let mut res = 0;
        for i in 0..n {
            res = std::cmp::max(res, dp[(1 << n) - 1][i]);
        }
        res
    }
}