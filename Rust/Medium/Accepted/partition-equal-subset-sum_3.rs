impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        

        let sum: i32 = nums.iter().sum();
        if sum % 2 != 0 {
            return false;
        }
        let sum = sum / 2;
        let mut dp = vec![false; (sum + 1) as usize];
        dp[0] = true;
        for n in nums {
            for i in (n..=sum).rev() {
                dp[i as usize] = dp[i as usize] || dp[(i - n) as usize];
            }
        }
        dp[sum as usize]
    }
}