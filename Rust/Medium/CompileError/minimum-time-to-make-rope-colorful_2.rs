impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 3]; colors.len()];
        for i in 0..colors.len() {
            for j in 0..3 {
                let c = colors.as_bytes()[i] - b'a';
                dp[i][j] = if c == j as u8 {
                    0
                } else {
                    needed_time[i]
                };
                if i > 0 {
                    dp[i][j] += dp[i - 1].iter().filter(|&x| x != &dp[i][j]).min().unwrap();
                }
            }
        }
        *dp.last().unwrap().iter().min().unwrap()
    }
}