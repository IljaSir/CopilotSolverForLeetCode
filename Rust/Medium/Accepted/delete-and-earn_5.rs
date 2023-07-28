impl Solution {
    pub fn delete_and_earn(nums: Vec<i32>) -> i32 {
        
        let mut cnt = vec![0; 10001];
        for &x in &nums {
            cnt[x as usize] += x;
        }
        let mut dp = vec![0; 10001];
        dp[1] = cnt[1];
        for i in 2..10001 {
            dp[i] = dp[i - 1].max(dp[i - 2] + cnt[i]);
        }
        dp[10000]
    }
}