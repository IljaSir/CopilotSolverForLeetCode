impl Solution {
    pub fn left_rigth_difference(nums: Vec<i32>) -> Vec<i32> {
        
        let mut left_sum = vec![0; nums.len()];
        let mut right_sum = vec![0; nums.len()];
        let mut answer = vec![0; nums.len()];
        left_sum[0] = nums[0];
        for i in 1..nums.len() {
            left_sum[i] = left_sum[i-1] + nums[i];
        }
        right_sum[nums.len()-1] = nums[nums.len()-1];
        for i in (0..nums.len()-1).rev() {
            right_sum[i] = right_sum[i+1] + nums[i];
        }
        for i in 0..nums.len() {
            answer[i] = (left_sum[i] - right_sum[i]).abs();
        }
        answer
    }
}