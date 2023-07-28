impl Solution {
    pub fn max_sum_div_three(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 3];
        for num in nums {
            let mut dp2 = vec![0; 3];
            for i in 0..3 {
                dp2[(num + dp[i]) % 3] = std::cmp::max(dp2[(num + dp[i]) % 3], dp[i] + num);
            }
            dp = dp2;
        }
        dp[0]
    }
}