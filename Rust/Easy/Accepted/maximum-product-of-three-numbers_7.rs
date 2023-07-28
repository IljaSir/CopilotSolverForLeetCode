impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut max = nums[n - 1] * nums[n - 2] * nums[n - 3];
        if nums[0] < 0 && nums[1] < 0 {
            max = max.max(nums[0] * nums[1] * nums[n - 1]);
        }
        max
    }
}