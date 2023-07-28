impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; stones.len()]; stones.len()];
        for i in 0..stones.len() {
            for j in 0..stones.len() {
                if i == j {
                    dp[i][j] = 0;
                } else if i > j {
                    dp[i][j] = dp[j][i];
                } else {
                    let mut max = 0;
                    for k in j + 1..stones.len() {
                        if stones[k] - stones[j] > stones[j] - stones[i] {
                            break;
                        }
                        if stones[k] - stones[j] <= stones[j] - stones[i] {
                            max = std::cmp::max(max, dp[i][k]);
                        }
                    }
                    dp[i][j] = max + 1;
                }
            }
        }
        // println!("{:?}", dp);
        let mut ans = 0;
        for i in 1..stones.len() {
            ans = std::cmp::max(ans, dp[0][i]);
        }
        ans
    }
}