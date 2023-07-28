impl Solution {
    pub fn left_rigth_difference(nums: Vec<i32>) -> Vec<i32> {
        
        let mut left_sum = vec![0; nums.len()];
        let mut right_sum = vec![0; nums.len()];
        let mut answer = vec![0; nums.len()];
        for i in 0..nums.len() {
            if i > 0 {
                left_sum[i] = left_sum[i - 1] + nums[i - 1];
            }
        }
        for i in (0..nums.len()).rev() {
            if i < nums.len() - 1 {
                right_sum[i] = right_sum[i + 1] + nums[i + 1];
            }
        }
        for i in 0..nums.len() {
            answer[i] = (left_sum[i] - right_sum[i]).abs();
        }
        answer
    }
}