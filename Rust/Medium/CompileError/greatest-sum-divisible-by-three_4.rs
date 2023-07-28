impl Solution {
    pub fn max_sum_div_three(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 3];
        for n in nums {
            let mut dp2 = vec![0; 3];
            for i in 0..3 {
                dp2[(n + i) % 3] = std::cmp::max(dp[(n + i) % 3], dp2[(n + i) % 3]);
                dp2[i] = std::cmp::max(dp[i], dp2[i]);
            }
            dp = dp2;
        }
        dp[0]
    }
}