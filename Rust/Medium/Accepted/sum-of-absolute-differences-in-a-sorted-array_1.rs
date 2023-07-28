impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut sum = vec![0; n];
        sum[0] = nums[0];
        for i in 1..n {
            sum[i] = sum[i - 1] + nums[i];
        }
        let mut res = vec![0; n];
        for i in 0..n {
            let left = i as i32 * nums[i] - if i == 0 { 0 } else { sum[i - 1] };
            let right = if i == n - 1 { 0 } else { sum[n - 1] - sum[i] } - (n as i32 - i as i32 - 1) * nums[i];
            res[i] = left + right;
        }
        res
    }
}