impl Solution {
    pub fn maximum_sum(arr: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; arr.len()];
        let mut dp2 = vec![0; arr.len()];
        dp[0] = arr[0];
        dp2[0] = arr[0];
        for i in 1..arr.len() {
            dp[i] = arr[i] + dp[i-1].max(0);
            dp2[i] = arr[i] + dp2[i-1].max(0);
            if arr[i] > dp2[i] {
                dp2[i] = arr[i];
            }
        }
        dp.iter().cloned().max().unwrap().max(dp2.iter().cloned().max().unwrap())
    }
}