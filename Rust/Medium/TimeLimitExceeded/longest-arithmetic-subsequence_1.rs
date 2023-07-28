impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![2; n]; n];
        let mut ans = 2;
        for i in 0..n {
            for j in i+1..n {
                let mut k = j + 1;
                while k < n {
                    if nums[k] - nums[j] == nums[j] - nums[i] {
                        dp[j][k] = dp[i][j] + 1;
                        ans = ans.max(dp[j][k]);
                    }
                    k += 1;
                }
            }
        }
        ans
    }
}