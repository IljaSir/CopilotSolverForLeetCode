impl Solution {
    pub fn combination_sum4(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut dp = vec![0; target as usize + 1];
        dp[0] = 1;
        for i in 1..=target as usize {
            for &num in &nums {
                if num <= i as i32 {
                    dp[i] += dp[i - num as usize];
                }
            }
        }
        dp[target as usize]
    }
}