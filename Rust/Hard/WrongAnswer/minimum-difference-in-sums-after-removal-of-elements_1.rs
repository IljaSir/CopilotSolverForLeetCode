impl Solution {
    pub fn minimum_difference(nums: Vec<i32>) -> i64 {
        
        let n = nums.len() / 3;
        let mut nums = nums;
        nums.sort();
        let mut sum1 = 0;
        let mut sum2 = 0;
        for i in 0..n {
            sum1 += nums[i];
            sum2 += nums[2 * n + i];
        }
        for i in 0..n {
            sum1 -= nums[n + i];
            sum2 -= nums[n - i - 1];
            if sum1 < sum2 {
                sum1 += nums[n + i];
                sum2 += nums[n - i - 1];
            } else {
                break;
            }
        }
        (sum1 - sum2) as i64
    }
}