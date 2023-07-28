impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        

        let mut sum = 0;
        for num in nums.iter() {
            sum += num;
        }
        if sum % 2 == 1 {
            return false;
        }
        let sum = sum / 2;
        let mut dp = vec![false; (sum + 1) as usize];
        dp[0] = true;
        for num in nums.iter() {
            for i in (0..sum + 1).rev() {
                if i >= *num {
                    dp[i as usize] = dp[i as usize] || dp[(i - num) as usize];
                }
            }
        }
        dp[sum as usize]
    }
}