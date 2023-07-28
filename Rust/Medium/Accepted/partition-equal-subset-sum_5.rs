impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        

        let sum = nums.iter().sum::<i32>() as usize;
        if sum % 2 != 0 {
            return false;
        }
        let sum = sum / 2;
        let mut dp = vec![false; sum + 1];
        dp[0] = true;
        for i in 0..nums.len() {
            for j in (nums[i] as usize..=sum).rev() {
                dp[j] = dp[j] || dp[j - nums[i] as usize];
            }
        }
        dp[sum]
    }
}