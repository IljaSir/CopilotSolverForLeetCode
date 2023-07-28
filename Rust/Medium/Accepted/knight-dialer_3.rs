impl Solution {
    pub fn knight_dialer(n: i32) -> i32 {
        
        let mut dp = vec![vec![0; 10]; n as usize];
        for i in 0..10 {
            dp[0][i] = 1;
        }
        let moves = vec![vec![4, 6], vec![6, 8], vec![7, 9], vec![4, 8], vec![3, 9, 0], vec![], vec![1, 7, 0], vec![2, 6], vec![1, 3], vec![2, 4]];
        for i in 1..n as usize {
            for j in 0..10 {
                for k in 0..moves[j].len() {
                    dp[i][j] = (dp[i][j] + dp[i - 1][moves[j][k] as usize]) % 1000000007;
                }
            }
        }
        let mut res = 0;
        for i in 0..10 {
            res = (res + dp[n as usize - 1][i]) % 1000000007;
        }
        res
    }
}