impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        

        let mut ret = vec![1; nums.len()];
        let mut l = 1;
        let mut r = 1;
        for i in 0..nums.len() {
            ret[i] *= l;
            l *= nums[i];
            ret[nums.len() - i - 1] *= r;
            r *= nums[nums.len() - i - 1];
        }
        ret
    }
}