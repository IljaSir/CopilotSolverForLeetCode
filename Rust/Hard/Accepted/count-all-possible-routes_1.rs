impl Solution {
    pub fn count_routes(locations: Vec<i32>, start: i32, finish: i32, fuel: i32) -> i32 {
        
        let n = locations.len();
        let mut dp = vec![vec![0; n]; fuel as usize + 1];
        dp[0][start as usize] = 1;
        let mut ans = 0;
        let modu = 1e9 as i32 + 7;
        for i in 0..fuel as usize {
            for j in 0..n {
                for k in 0..n {
                    if j == k {
                        continue;
                    }
                    let dis = (locations[j] - locations[k]).abs();
                    if i as i32 + dis <= fuel {
                        dp[i as usize + dis as usize][k] += dp[i][j];
                        dp[i as usize + dis as usize][k] %= modu;
                    }
                }
            }
        }
        for i in 0..=fuel as usize {
            ans += dp[i][finish as usize];
            ans %= modu;
        }
        ans
    }
}