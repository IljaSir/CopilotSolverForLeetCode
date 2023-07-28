impl Solution {
    pub fn min_sessions(tasks: Vec<i32>, session_time: i32) -> i32 {
        
        let n = tasks.len();
        let mut dp = vec![vec![0; 1 << n]; session_time as usize];
        for i in 0..n {
            dp[0][1 << i] = 1;
        }
        for i in 1..session_time as usize {
            for mask in 0..(1 << n) {
                dp[i][mask] = dp[i - 1][mask];
                for j in 0..n {
                    if mask & (1 << j) != 0 {
                        let prev_mask = mask ^ (1 << j);
                        dp[i][mask] = std::cmp::max(dp[i][mask], dp[i - 1][prev_mask]);
                        if i as i32 + tasks[j] <= session_time {
                            dp[i][mask] = std::cmp::max(dp[i][mask], dp[(i as i32 + tasks[j]) as usize - 1][prev_mask] + 1);
                        }
                    }
                }
            }
        }
        dp[session_time as usize - 1][(1 << n) - 1]
    }
}