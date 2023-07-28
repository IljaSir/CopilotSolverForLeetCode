impl Solution {
    pub fn winner_square_game(n: i32) -> bool {
        
        let mut dp = vec![false; n as usize + 1];
        for i in 1..=n {
            for j in 1..=i {
                if j * j > i {
                    break;
                }
                if dp[(i - j * j) as usize] == false {
                    dp[i as usize] = true;
                    break;
                }
            }
        }
        dp[n as usize]
    }
}