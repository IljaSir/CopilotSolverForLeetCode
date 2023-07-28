impl Solution {
    pub fn find_minimum_time(tasks: Vec<Vec<i32>>) -> i32 {
        
        let mut tasks = tasks;
        tasks.sort_by_key(|x| x[0]);
        let mut dp = vec![0; tasks.len()];
        dp[0] = tasks[0][2];
        for i in 1..tasks.len() {
            dp[i] = tasks[i][2];
            for j in (0..i).rev() {
                if tasks[j][1] <= tasks[i][0] {
                    dp[i] = dp[i].max(dp[j] + tasks[i][2]);
                    break;
                }
            }
        }
        dp.into_iter().max().unwrap()
    }
}