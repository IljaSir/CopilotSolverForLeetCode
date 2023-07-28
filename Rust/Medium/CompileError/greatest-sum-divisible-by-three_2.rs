impl Solution {
    pub fn max_sum_div_three(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 3];
        for n in nums {
            let mut tmp = dp.clone();
            for i in 0..3 {
                tmp[(i + n % 3) % 3] = dp[i].max(dp[i] + n);
            }
            dp = tmp;
        }
        dp[0]
    }
}