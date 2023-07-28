impl Solution {
    pub fn left_rigth_difference(nums: Vec<i32>) -> Vec<i32> {
        
        let mut left_sum: Vec<i32> = vec![0; nums.len()];
        let mut right_sum: Vec<i32> = vec![0; nums.len()];
        for i in 1..nums.len() {
            left_sum[i] = left_sum[i - 1] + nums[i - 1];
        }
        for i in (0..nums.len() - 1).rev() {
            right_sum[i] = right_sum[i + 1] + nums[i + 1];
        }
        left_sum
            .iter()
            .zip(right_sum.iter())
            .map(|(l, r)| (l - r).abs())
            .collect()
    }
}