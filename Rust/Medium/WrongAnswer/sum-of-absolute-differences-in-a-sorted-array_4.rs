impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res: Vec<i32> = vec![0; nums.len()];
        let mut sum = 0;
        for i in 1..nums.len() {
            sum += (nums[i] - nums[i-1]) * (i as i32);
            res[i] = sum;
        }
        sum = 0;
        for i in (0..nums.len()-1).rev() {
            sum += (nums[i+1] - nums[i]) * ((nums.len() - i - 1) as i32);
            res[i] -= sum;
        }
        res
    }
}