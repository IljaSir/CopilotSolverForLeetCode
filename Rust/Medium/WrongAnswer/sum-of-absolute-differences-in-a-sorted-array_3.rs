impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut sum = 0;
        let mut ans = vec![0; n];
        for i in 0..n {
            ans[0] += nums[i] - nums[0];
            sum += nums[i];
        }
        for i in 1..n {
            ans[i] = ans[i-1] + i as i32 * (nums[i] - nums[i-1]) - (sum - nums[i-1] - i as i32 * nums[i-1]);
        }
        ans
    }
}