impl Solution {
    pub fn number_of_ways(start_pos: i32, end_pos: i32, k: i32) -> i32 {
        
        let mut dp = vec![vec![0; 1001]; 1001];
        let modu = 1_000_000_007;
        dp[0][start_pos as usize] = 1;
        for i in 1..=k {
            for j in 1..=1000 {
                dp[i as usize][j as usize] = (dp[i as usize - 1][j as usize - 1] + dp[i as usize - 1][j as usize + 1]) % modu;
            }
        }
        dp[k as usize][end_pos as usize]
    }
}