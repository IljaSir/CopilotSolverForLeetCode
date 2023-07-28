impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + nums[i];
        }
        let mut res = vec![0; n];
        for i in 0..n {
            res[i] = (nums[i] * (i as i32) - sum[i]) + (sum[n] - sum[i + 1] - nums[i] * (n - i - 1) as i32);
        }
        res
    }
}