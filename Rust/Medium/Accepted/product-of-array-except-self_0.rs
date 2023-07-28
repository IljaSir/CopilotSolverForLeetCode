impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        

        let mut left = vec![1; nums.len()];
        let mut right = vec![1; nums.len()];
        for i in 1..nums.len() {
            left[i] = left[i-1] * nums[i-1];
            right[nums.len()-i-1] = right[nums.len()-i] * nums[nums.len()-i];
        }
        for i in 0..nums.len() {
            left[i] *= right[i];
        }
        left
    }
}