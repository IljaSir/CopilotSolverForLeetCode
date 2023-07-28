impl Solution {
    pub fn flip_lights(n: i32, presses: i32) -> i32 {
        

        let n = n as usize;
        let presses = presses as usize;
        let mut dp = vec![vec![0; 16]; presses + 1];
        dp[0][0] = 1;
        for i in 1..presses + 1 {
            dp[i][0] = 1; // button 1
            dp[i][1] = n as i32; // button 2
            dp[i][2] = (n + 1) / 2; // button 3
            dp[i][3] = (n + 1) / 2; // button 4
            dp[i][4] = n as i32 - (n + 1) / 2; // button 1 + 2
            dp[i][5] = n as i32 - (n + 1) / 2; // button 1 + 3
            dp[i][6] = (n + 1) / 2; // button 1 + 4
            dp[i][7] = (n + 1) / 2; // button 2 + 3
            dp[i][8] = (n + 1) / 2; // button 2 + 4
            dp[i][9] = n as i32 - (n + 1) / 2; // button 3 + 4
            dp[i][10] = n as i32 - (n + 1) / 2; // button 1 + 2 + 3
            dp[i][11] = (n + 1) / 2; // button 1 + 2 + 4
            dp[i][12] = (n + 1) / 2; // button 1 + 3 + 4
            dp[i][13] = n as i32 - (n + 1) / 2; // button 2 + 3 + 4
            dp[i][14] = n as i32 - (n + 1) / 2; // button 1 + 2 + 3 + 4
            dp[i][15] = 1; // button 1 + 2 + 3 + 4
        }
        let mut res = 0;
        for i in 0..
    }
}