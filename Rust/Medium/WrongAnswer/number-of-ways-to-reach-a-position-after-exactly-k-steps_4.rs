impl Solution {
    pub fn number_of_ways(start_pos: i32, end_pos: i32, k: i32) -> i32 {
        
        let k = k as usize;
        let mut dp = vec![vec![0; 1001]; 1001];
        let mut dp_new = vec![vec![0; 1001]; 1001];
        dp[start_pos as usize][0] = 1;
        for i in 0..k {
            for j in 0..1001 {
                if dp[j][i] > 0 {
                    if j > 0 {
                        dp_new[j - 1][i + 1] = (dp_new[j - 1][i + 1] + dp[j][i]) % 1000000007;
                    }
                    if j < 1000 {
                        dp_new[j + 1][i + 1] = (dp_new[j + 1][i + 1] + dp[j][i]) % 1000000007;
                    }
                }
            }
            dp = dp_new;
            dp_new = vec![vec![0; 1001]; 1001];
        }
        dp[end_pos as usize][k]
    }
}