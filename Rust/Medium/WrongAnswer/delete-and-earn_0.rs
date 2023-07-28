impl Solution {
    pub fn delete_and_earn(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 10001];
        for num in nums {
            dp[num as usize] += num;
        }
        for i in 2..10001 {
            dp[i] = dp[i].max(dp[i-1]);
            dp[i] = dp[i].max(dp[i-2] + dp[i]);
        }
        dp[10000]
    }
}