impl Solution {
    pub fn winner_square_game(n: i32) -> bool {
        
        let mut dp = vec![false; n as usize + 1];
        dp[1] = true;
        for i in 2..=n as usize {
            for j in 1..=(i as f64).sqrt() as usize {
                if !dp[i - j * j] {
                    dp[i] = true;
                    break;
                }
            }
        }
        dp[n as usize]
    }
}