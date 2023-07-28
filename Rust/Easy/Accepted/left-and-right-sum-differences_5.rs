impl Solution {
    pub fn left_rigth_difference(nums: Vec<i32>) -> Vec<i32> {
        
        let mut left_sum = vec![0; nums.len()];
        let mut right_sum = vec![0; nums.len()];
        let mut sum = 0;
        for i in 0..nums.len() {
            left_sum[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for i in (0..nums.len()).rev() {
            right_sum[i] = sum;
            sum += nums[i];
        }
        left_sum
            .iter()
            .zip(right_sum.iter())
            .map(|(l, r)| (l - r).abs())
            .collect()
    }
}