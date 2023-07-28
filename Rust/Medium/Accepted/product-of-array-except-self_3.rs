impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        

        let mut ans = vec![1; nums.len()];
        let mut left = 1;
        let mut right = 1;
        for i in 0..nums.len() {
            ans[i] *= left;
            left *= nums[i];
            ans[nums.len() - i - 1] *= right;
            right *= nums[nums.len() - i - 1];
        }
        ans
    }
}