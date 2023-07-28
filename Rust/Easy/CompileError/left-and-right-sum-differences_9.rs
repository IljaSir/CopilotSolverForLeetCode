impl Solution {
    pub fn left_rigth_difference(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![];
        let mut left_sum = 0;
        let mut right_sum = nums.iter().sum();
        for i in 0..nums.len() {
            right_sum -= nums[i];
            result.push((left_sum - right_sum).abs());
            left_sum += nums[i];
        }
        result
    }
}