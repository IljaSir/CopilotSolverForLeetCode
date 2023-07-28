impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        

        let sum: i32 = nums.iter().sum();
        if sum % 2 != 0 {
            return false;
        }
        let target = sum / 2;
        let mut dp = vec![false; target as usize + 1];
        dp[0] = true;
        for num in nums {
            for i in (num as usize..=target as usize).rev() {
                dp[i] = dp[i] || dp[i - num as usize];
            }
        }
        dp[target as usize]
    }
}