impl Solution {
    pub fn maximum_sum(arr: Vec<i32>) -> i32 {
        
        let mut dp: Vec<(i32, i32)> = vec![(arr[0], arr[0]); arr.len()]; // (with, without)
        let mut max = arr[0];
        for i in 1..arr.len() {
            dp[i] = (
                arr[i] + dp[i-1].1.max(0),
                dp[i-1].0.max(dp[i-1].1),
            );
            max = max.max(dp[i].0).max(dp[i].1);
        }
        max
    }
}