impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        

        let sum = nums.iter().sum::<i32>();
        if sum % 2 != 0 {
            return false;
        }
        let target = sum / 2;
        let mut dp = vec![false; (target + 1) as usize];
        dp[0] = true;
        for &num in &nums {
            for i in (num..=target).rev() {
                dp[i as usize] = dp[i as usize] || dp[(i - num) as usize];
            }
        }
        dp[target as usize]
    }
}