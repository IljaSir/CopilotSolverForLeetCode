impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut res = vec![0; n];
        let mut sum = 0;
        for i in 1..n {
            sum += (nums[i] - nums[i - 1]) * i as i32;
            res[i] = sum;
        }
        sum = 0;
        for i in (0..n - 1).rev() {
            sum += (nums[i + 1] - nums[i]) * (n - i - 1) as i32;
            res[i] += sum;
        }
        res
    }
}