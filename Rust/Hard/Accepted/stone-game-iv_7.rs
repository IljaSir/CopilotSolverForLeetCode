impl Solution {
    pub fn winner_square_game(n: i32) -> bool {
        
        let n = n as usize;
        let mut dp = vec![false; n+1];
        for i in 1..=n {
            for j in 1..=i {
                let k = j * j;
                if k > i {
                    break;
                }
                if !dp[i - k] {
                    dp[i] = true;
                    break;
                }
            }
        }
        dp[n]
    }
}