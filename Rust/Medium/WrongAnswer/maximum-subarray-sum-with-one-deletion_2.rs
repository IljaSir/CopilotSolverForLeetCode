impl Solution {
    pub fn maximum_sum(arr: Vec<i32>) -> i32 {
        
        let mut max = arr[0];
        let mut dp = vec![0; arr.len()];
        dp[0] = arr[0];
        for i in 1..arr.len() {
            dp[i] = arr[i] + dp[i - 1].max(0);
            max = max.max(dp[i]);
        }
        let mut sum = 0;
        for i in (1..arr.len()).rev() {
            sum += arr[i];
            max = max.max(sum + dp[i - 1].max(0));
        }
        max
    }
}