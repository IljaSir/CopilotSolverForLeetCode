impl Solution {
    pub fn integer_break(n: i32) -> i32 {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 1..=n {
            let mut cur_max = 0;
            for j in 1..i {
                cur_max = cur_max.max(j * (i - j)).max(j * dp[(i - j) as usize]);
            }
            dp[i as usize] = cur_max;
        }
        dp[n as usize]
    }
}