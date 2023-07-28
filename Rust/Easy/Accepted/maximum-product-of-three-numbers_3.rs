impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let max1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        let max2 = nums[0] * nums[1] * nums[n - 1];
        if max1 > max2 {
            max1
        } else {
            max2
        }
    }
}