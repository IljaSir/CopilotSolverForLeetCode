impl Solution {
    pub fn min_cost(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![0; n]; n];
        let mut cost = vec![vec![0; n]; n];
        let mut freq = vec![0; n];
        for i in 0..n {
            dp[i][i] = 1;
            freq[nums[i] as usize] += 1;
        }
        for i in 0..n {
            for j in i + 1..n {
                dp[i][j] = dp[i][j - 1];
                if freq[nums[j] as usize] == 1 {
                    dp[i][j] += 1;
                }
                freq[nums[j] as usize] += 1;
            }
            for j in i..n {
                freq[nums[j] as usize] = 0;
            }
        }
        for i in 0..n {
            for j in i..n {
                cost[i][j] = k + dp[i][j] as i32;
            }
        }
        let mut dp = vec![0; n];
        for i in 0..n {
            dp[i] = cost[0][i];
        }
        for i in 1..n {
            for j in i..n {
                dp[j] = min(dp[j], dp[i - 1] + cost[i][j]);
            }
        }
        dp[n - 1]
    }
}