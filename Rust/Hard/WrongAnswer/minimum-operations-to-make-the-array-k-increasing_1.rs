impl Solution {
    pub fn k_increasing(arr: Vec<i32>, k: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0; n];
        for i in 1..n {
            dp[i] = dp[i - 1] + (arr[i] - arr[i - 1]).max(0);
            if i >= k as usize {
                dp[i] = dp[i].min(dp[i - k as usize] + (arr[i - k as usize] - arr[i]).max(0));
            }
        }
        dp[n - 1]
    }
}