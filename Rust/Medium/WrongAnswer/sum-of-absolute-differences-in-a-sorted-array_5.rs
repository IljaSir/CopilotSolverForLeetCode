impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let sum: i32 = nums.iter().sum();
        let mut res = vec![0; n];
        for i in 0..n {
            res[i] = nums[i] * i as i32 - (sum - nums[i]) + (sum - nums[i]) - nums[i] * (n - i - 1) as i32;
        }
        res
    }
}