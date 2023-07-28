impl Solution {
    pub fn minimum_difference(nums: Vec<i32>) -> i32 {
        
        let n = nums.len() / 2;
        let mut dp = vec![0; 1 << n];
        let mut ans = i32::MAX;
        for i in 0..(1 << n) {
            let mut sum = 0;
            for j in 0..n {
                if i & (1 << j) > 0 {
                    sum += nums[j];
                } else {
                    sum -= nums[j];
                }
            }
            dp[i] = sum;
        }
        dp.sort();
        for i in 0..(1 << n) {
            ans = ans.min((dp[i] - dp[i ^ ((1 << n) - 1)]).abs());
        }
        ans
    }
}