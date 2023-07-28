impl Solution {
    pub fn max_sum_after_partitioning(arr: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut dp = vec![0; arr.len() + 1];
        for i in 0..arr.len() {
            let mut max = 0;
            for j in 1..=k {
                if i >= j - 1 {
                    max = max.max(arr[i - j + 1]);
                    dp[i + 1] = dp[i + 1].max(dp[i - j + 1] + max * j as i32);
                }
            }
        }
        dp[arr.len()]
    }
}