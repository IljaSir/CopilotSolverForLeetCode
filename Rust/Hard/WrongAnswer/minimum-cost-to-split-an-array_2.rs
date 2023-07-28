impl Solution {
    pub fn min_cost(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut cnt = vec![0; nums.len()];
        let mut s = vec![0; nums.len()];
        for i in 0..nums.len() {
            cnt[nums[i] as usize] += 1;
        }
        let mut t = 0;
        for i in 0..nums.len() {
            if cnt[nums[i] as usize] == 1 {
                t += 1;
            }
            s[i] = t;
        }
        let mut dp = vec![vec![0; nums.len()]; k as usize];
        for i in 0..nums.len() {
            dp[0][i] = k + s[i];
        }
        for i in 1..k as usize {
            for j in (i + 1)..nums.len() {
                let mut m = std::i32::MAX;
                for l in i..j {
                    m = std::cmp::min(m, dp[i - 1][l - 1] + k + s[j] - s[l]);
                }
                dp[i][j] = m;
            }
        }
        dp[k as usize - 1][nums.len() - 1]
    }
}