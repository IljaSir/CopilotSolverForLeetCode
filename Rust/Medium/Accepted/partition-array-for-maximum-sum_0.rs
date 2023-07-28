impl Solution {
    pub fn max_sum_after_partitioning(arr: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let n = arr.len();
        let mut dp = vec![0; n + 1];
        for i in 0..n {
            let mut m = 0;
            for j in 1..=k {
                if i + 1 >= j {
                    m = m.max(arr[i + 1 - j]);
                    dp[i + 1] = dp[i + 1].max(dp[i + 1 - j] + m * j as i32);
                }
            }
        }
        dp[n]
    }
}