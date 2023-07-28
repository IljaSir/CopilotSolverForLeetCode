impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        

        let sum = nums.iter().sum::<i32>() as usize;
        if sum % 2 == 1 {
            return false;
        }
        let sum = sum / 2;
        let mut dp = vec![false; sum + 1];
        dp[0] = true;
        for i in 0..nums.len() {
            let num = nums[i] as usize;
            for j in (num..=sum).rev() {
                dp[j] |= dp[j - num];
            }
        }
        dp[sum]
    }
}