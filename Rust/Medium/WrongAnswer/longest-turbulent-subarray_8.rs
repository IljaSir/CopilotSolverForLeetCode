impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut dp = vec![1; arr.len()];
        for i in 1..arr.len() {
            if arr[i] > arr[i-1] {
                if i%2 == 1 {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = 2;
                }
            } else if arr[i] < arr[i-1] {
                if i%2 == 0 {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = 2;
                }
            }
        }
        *dp.iter().max().unwrap() as i32
    }
}