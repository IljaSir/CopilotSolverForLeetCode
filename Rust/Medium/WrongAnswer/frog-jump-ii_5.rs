impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let n = stones.len();
        for i in 1..n {
            res = res.max(stones[i] - stones[i - 1]);
        }
        res
    }

    pub fn frog_jump(stones: Vec<i32>) -> i32 {
        let n = stones.len();
        let mut dp = vec![vec![false; n]; n];
        dp[0][0] = true;
        for i in 1..n {
            for j in 0..i {
                let k = (stones[i] - stones[j]) as usize;
                if k > j + 1 {
                    break;
                }
                dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
            }
        }
        (0..n)
            .find(|&i| dp[n - 1][i])
            .map(|i| Self::max_jump(stones[i..].to_vec()))
            .unwrap()
    }
}