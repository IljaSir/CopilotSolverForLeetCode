impl Solution {
    pub fn num_rolls_to_target(n: i32, k: i32, target: i32) -> i32 {
        
        let modu = 1000000007;
        let mut dp = vec![0; target as usize + 1];
        dp[0] = 1;
        for _i in 0..n {
            let mut ndp = vec![0; target as usize + 1];
            for j in 0..=target {
                for l in 1..=k {
                    if j + l > target {
                        break;
                    }
                    ndp[j as usize + l as usize] = (ndp[j as usize + l as usize] + dp[j as usize]) % modu;
                }
            }
            dp = ndp;
        }
        dp[target as usize]
    }
}