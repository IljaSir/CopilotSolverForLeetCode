impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0;nums.len()];nums.len()];
        let mut ans = 2;
        for i in 0..nums.len(){
            for j in i+1..nums.len(){
                let diff = nums[i] - nums[j];
                let mut max = 2;
                for k in 0..i{
                    if nums[k] - nums[i] == diff{
                        max = std::cmp::max(max,dp[k][i]+1);
                    }
                }
                dp[i][j] = max;
                ans = std::cmp::max(ans,max);
            }
        }
        ans
    }
}