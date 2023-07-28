impl Solution {
    pub fn max_sum_after_partitioning(arr: Vec<i32>, k: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0; n];
        for i in 0..n {
            let mut max = 0;
            for j in 0..k.min(i as i32 + 1) {
                max = max.max(arr[i - j as usize]);
                dp[i] = dp[i].max(if i as i32 - j > 0 { dp[i - j as usize - 1] } else { 0 } + max * (j + 1));
            }
        }
        dp[n - 1]
    }
}