impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        

        let mut sum = 0;
        for n in nums.iter() {
            sum += n;
        }
        if sum % 2 == 1 {
            return false;
        }
        let sum = sum / 2;
        let mut dp = vec![vec![false; (sum + 1) as usize]; (nums.len() + 1) as usize];
        for i in 0..(nums.len() + 1) {
            dp[i][0] = true;
        }
        for i in 1..(nums.len() + 1) {
            for j in 1..(sum + 1) {
                if j >= nums[i - 1] as i32 {
                    dp[i][j as usize] = dp[i - 1][j as usize] || dp[i - 1][(j - nums[i - 1]) as usize];
                } else {
                    dp[i][j as usize] = dp[i - 1][j as usize];
                }
            }
        }
        dp[nums.len()][sum as usize]
    }
}