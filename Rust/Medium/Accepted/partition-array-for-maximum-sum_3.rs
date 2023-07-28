impl Solution {
    pub fn max_sum_after_partitioning(arr: Vec<i32>, k: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0; n + 1];
        for i in 0..n {
            let mut max = 0;
            for j in 0..k {
                if i as i32 - j < 0 {
                    break;
                }
                max = max.max(arr[i - j as usize]);
                dp[i + 1] = dp[i + 1].max(dp[i - j as usize] + max * (j + 1));
            }
        }
        dp[n]
    }
}