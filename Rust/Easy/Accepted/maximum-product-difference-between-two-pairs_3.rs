impl Solution {
    pub fn max_product_difference(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        nums[n - 1] * nums[n - 2] - nums[0] * nums[1]
    }
}