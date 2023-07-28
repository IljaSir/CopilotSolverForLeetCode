impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        

        let mut result = vec![1; nums.len()];
        let mut left = 1;
        let mut right = 1;
        for i in 0..nums.len() {
            result[i] *= left;
            result[nums.len() - 1 - i] *= right;
            left *= nums[i];
            right *= nums[nums.len() - 1 - i];
        }
        return result;
    }
}