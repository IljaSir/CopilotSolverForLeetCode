impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        

        let mut res = vec![1; nums.len()];
        let mut left = 1;
        let mut right = 1;
        for i in 0..nums.len() {
            res[i] *= left;
            left *= nums[i];
            res[nums.len() - 1 - i] *= right;
            right *= nums[nums.len() - 1 - i];
        }
        res
    }
}