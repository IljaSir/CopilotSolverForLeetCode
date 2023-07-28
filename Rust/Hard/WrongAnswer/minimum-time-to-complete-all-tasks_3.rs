impl Solution {
    pub fn find_minimum_time(tasks: Vec<Vec<i32>>) -> i32 {
        
        let mut t = tasks;
        t.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut dp = vec![0; t.len()];
        for i in 0..t.len() {
            let mut j = i;
            while j > 0 {
                if t[j - 1][1] < t[i][0] {
                    break;
                }
                j -= 1;
            }
            dp[i] = if j > 0 {
                dp[j - 1] + t[i][1] - t[i][0] + 1
            } else {
                t[i][1] - t[i][0] + 1
            };
            if i > 0 {
                dp[i] = dp[i].min(dp[i - 1]);
            }
        }
        dp[t.len() - 1]
    }
}