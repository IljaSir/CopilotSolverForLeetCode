impl Solution {
    pub fn min_cost(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![vec![0; nums.len()]; k as usize];
        let mut cost = vec![0; nums.len()];
        let mut count = vec![0; nums.len()];
        for i in 0..nums.len() {
            count[nums[i] as usize] += 1;
            if count[nums[i] as usize] == 1 {
                cost[i] = 1;
            } else if count[nums[i] as usize] == 2 {
                cost[i] = -1;
            } else {
                cost[i] = -2;
            }
            if i > 0 {
                cost[i] += cost[i - 1];
            }
        }
        for i in 0..k as usize {
            for j in 0..nums.len() {
                if i == 0 {
                    dp[i][j] = cost[j];
                } else {
                    let mut min = std::i32::MAX;
                    for m in 0..j {
                        let c = dp[i - 1][m] + cost[j] - cost[m];
                        if c < min {
                            min = c;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        dp[k as usize - 1][nums.len() - 1]
    }
}