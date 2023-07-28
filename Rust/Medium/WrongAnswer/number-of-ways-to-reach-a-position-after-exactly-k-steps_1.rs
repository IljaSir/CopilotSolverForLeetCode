impl Solution {
    pub fn number_of_ways(start_pos: i32, end_pos: i32, k: i32) -> i32 {
        
        let modu = 1000000007;
        let mut dp = vec![vec![0; 1001]; 1001];
        dp[0][start_pos as usize] = 1;
        for i in 0..k {
            for j in 0..1001 {
                if dp[i as usize][j] != 0 {
                    if j > 0 {
                        dp[(i + 1) as usize][(j - 1) as usize] = (dp[(i + 1) as usize][(j - 1) as usize] + dp[i as usize][j]) % modu;
                    }
                    if j < 1000 {
                        dp[(i + 1) as usize][(j + 1) as usize] = (dp[(i + 1) as usize][(j + 1) as usize] + dp[i as usize][j]) % modu;
                    }
                }
            }
        }
        dp[k as usize][end_pos as usize]
    }
}