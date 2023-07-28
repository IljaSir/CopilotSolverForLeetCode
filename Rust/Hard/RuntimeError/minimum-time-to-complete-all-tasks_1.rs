impl Solution {
    pub fn find_minimum_time(tasks: Vec<Vec<i32>>) -> i32 {
        
        let mut tasks = tasks;
        tasks.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut dp = vec![0; tasks.len()];
        dp[0] = tasks[0][2];
        for i in 1..tasks.len() {
            let mut j = i - 1;
            while j >= 0 && tasks[j][1] >= tasks[i][0] {
                j -= 1;
            }
            if j >= 0 {
                dp[i] = dp[j] + tasks[i][2];
            } else {
                dp[i] = tasks[i][2];
            }
            if i > 0 {
                dp[i] = dp[i].min(dp[i - 1]);
            }
        }
        dp[tasks.len() - 1]
    }
}