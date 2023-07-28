impl Solution {
    pub fn count_vowel_strings(n: i32) -> i32 {
        
        // let mut dp = vec![vec![0; 5]; n as usize];
        // for i in 0..n as usize {
        //     for j in 0..5 {
        //         if i == 0 {
        //             dp[i][j] = 1;
        //         } else {
        //             for k in j..5 {
        //                 dp[i][j] += dp[i - 1][k];
        //             }
        //         }
        //     }
        // }
        // dp[n as usize - 1].iter().sum::<i32>()
        let mut dp = vec![1; 5];
        for _ in 0..n - 1 {
            for i in 1..5 {
                dp[i] += dp[i - 1];
            }
        }
        dp.iter().sum()
    }
}