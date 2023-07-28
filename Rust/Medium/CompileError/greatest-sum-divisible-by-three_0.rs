impl Solution {
    pub fn max_sum_div_three(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 3];
        for num in nums {
            let mut tmp = vec![0; 3];
            for i in 0..3 {
                tmp[(i + num % 3) % 3] = std::cmp::max(dp[(i + num % 3) % 3], dp[i] + num);
            }
            dp = tmp;
        }
        dp[0]
    }
}