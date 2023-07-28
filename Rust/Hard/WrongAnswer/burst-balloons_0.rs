impl Solution {
    pub fn max_coins(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.insert(0, 1);
        nums.push(1);
        let n = nums.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 1..n-1 {
            for j in 0..n-i-1 {
                let k = i + j;
                for t in j+1..k {
                    dp[j][k] = std::cmp::max(dp[j][k], nums[j]*nums[t]*nums[k] + dp[j][t] + dp[t][k]);
                }
            }
        }
        dp[0][n-1]
    }
}