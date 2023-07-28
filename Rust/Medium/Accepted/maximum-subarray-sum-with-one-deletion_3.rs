impl Solution {
    pub fn maximum_sum(arr: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; arr.len()];
        let mut max = arr[0];
        dp[0] = arr[0];
        for i in 1..arr.len() {
            dp[i] = std::cmp::max(arr[i], dp[i-1] + arr[i]);
            max = std::cmp::max(max, dp[i]);
        }
        let mut dp2 = vec![0; arr.len()];
        dp2[arr.len()-1] = arr[arr.len()-1];
        for i in (0..arr.len()-1).rev() {
            dp2[i] = std::cmp::max(arr[i], dp2[i+1] + arr[i]);
        }
        for i in 1..arr.len()-1 {
            max = std::cmp::max(max, dp[i-1] + dp2[i+1]);
        }
        max
    }
}