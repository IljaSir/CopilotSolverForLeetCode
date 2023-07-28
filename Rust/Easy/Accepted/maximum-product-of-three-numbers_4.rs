impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let len = nums.len();
        let a = nums[len - 1] * nums[len - 2] * nums[len - 3];
        let b = nums[len - 1] * nums[0] * nums[1];
        if a > b {
            a
        } else {
            b
        }
    }
}