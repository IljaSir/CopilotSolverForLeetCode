impl Solution {
    pub fn max_sum_after_partitioning(arr: Vec<i32>, k: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0; n];
        for i in 0..n {
            let mut cur_max = 0;
            for j in 1..=k as usize {
                if i >= j - 1 {
                    cur_max = cur_max.max(arr[i - j + 1]);
                    dp[i] = dp[i].max(dp.get(i - j).unwrap_or(&0) + cur_max * j as i32);
                }
            }
        }
        dp[n - 1]
    }
}