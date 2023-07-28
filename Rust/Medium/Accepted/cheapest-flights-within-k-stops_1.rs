impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let src = src as usize;
        let dst = dst as usize;
        let k = k as usize;
        let mut dp = vec![vec![std::i32::MAX; n]; k + 2];
        dp[0][src] = 0;
        for i in 1..k + 2 {
            dp[i][src] = 0;
            for flight in &flights {
                let from = flight[0] as usize;
                let to = flight[1] as usize;
                let price = flight[2];
                if dp[i - 1][from] != std::i32::MAX {
                    dp[i][to] = dp[i][to].min(dp[i - 1][from] + price);
                }
            }
        }
        if dp[k + 1][dst] == std::i32::MAX {
            -1
        } else {
            dp[k + 1][dst]
        }
    }
}