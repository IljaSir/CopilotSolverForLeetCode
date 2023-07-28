impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        // let mut dp = vec![vec![0; 2 + 1]; n + 1];
        // for j in 1..=2 {
        //     for i in 1..=n {
        //         if j == 1 {
        //             dp[i as usize][j as usize] = i;
        //         } else if i == 1 {
        //             dp[i as usize][j as usize] = 1;
        //         } else {
        //             let mut ans = i32::MAX;
        //             for k in 1..=i {
        //                 ans = ans.min(dp[k as usize - 1][j as usize - 1].max(dp[i as usize - k as usize][j as usize]));
        //             }
        //             dp[i as usize][j as usize] = ans + 1;
        //         }
        //     }
        // }
        // dp[n as usize][2 as usize]

        // let mut dp = vec![0; 2 + 1];
        // for i in 1..=n {
        //     let mut dp2 = vec![0; 2 + 1];
        //     for j in 1..=2 {
        //         if j == 1 {
        //             dp2[j as usize] = i;
        //         } else if i == 1 {
        //             dp2[j as usize] = 1;
        //         } else {
        //             let mut ans = i32::MAX;
        //             for k in 1..=i {
        //                 ans = ans.min(dp[j as usize - 1].max(dp2[j as usize]));
        //             }
        //             dp2[j as usize] = ans + 1;
        //         }
        //     }
        //     dp = dp2;
        // }
        // dp[2 as usize]

        let mut dp = vec![0; 2 + 1];
        for i in 1..=n {
            for j in (1..=2).rev() {
                if j == 1 {
                    dp[j as usize] = i;
                } else if i == 1 {
                    dp[j as usize] = 1;
                } else {
                    let mut ans = i32::MAX;
                    for k in
    }
}