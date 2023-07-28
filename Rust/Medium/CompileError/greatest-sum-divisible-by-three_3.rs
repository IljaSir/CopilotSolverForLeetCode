impl Solution {
    pub fn max_sum_div_three(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 3];
        for num in nums {
            let mut temp = dp.clone();
            for i in 0..3 {
                temp[(i + num % 3) % 3] = dp[(i + num % 3) % 3].max(dp[i] + num);
            }
            dp = temp;
        }
        dp[0]
    }
}