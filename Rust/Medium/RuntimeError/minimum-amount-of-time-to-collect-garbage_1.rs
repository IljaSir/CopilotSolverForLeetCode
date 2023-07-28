impl Solution {
    pub fn garbage_collection(garbage: Vec<String>, travel: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 3]; garbage.len()];
        for i in 0..garbage.len() {
            for j in 0..3 {
                dp[i][j] = if i == 0 {
                    garbage[i].chars().filter(|&c| c == "MPG".chars().nth(j).unwrap()).count() as i32 * travel[i]
                } else {
                    dp[i-1][j] + garbage[i].chars().filter(|&c| c == "MPG".chars().nth(j).unwrap()).count() as i32 * travel[i]
                };
                for k in 0..3 {
                    if k != j {
                        dp[i][j] = dp[i][j].min(dp[i][k] + garbage[i].chars().filter(|&c| c == "MPG".chars().nth(j).unwrap()).count() as i32 * travel[i]);
                    }
                }
            }
        }
        *dp.last().unwrap().iter().min().unwrap()
    }
}