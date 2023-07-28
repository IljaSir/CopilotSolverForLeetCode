impl Solution {
    pub fn number_of_ways(start_pos: i32, end_pos: i32, k: i32) -> i32 {
        
        let mut dp = vec![vec![0; 2001]; 1001];
        dp[0][start_pos as usize] = 1;
        let modu = 1000000007;
        for i in 0..k {
            for j in 1..2000 {
                dp[i as usize + 1][j] = (dp[i as usize + 1][j] + dp[i as usize][j - 1]) % modu;
                dp[i as usize + 1][j] = (dp[i as usize + 1][j] + dp[i as usize][j + 1]) % modu;
            }
        }
        dp[k as usize][end_pos as usize]
    }
}