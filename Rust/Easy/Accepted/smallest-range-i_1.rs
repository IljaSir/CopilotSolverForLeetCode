impl Solution {
    pub fn smallest_range_i(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut min, mut max) = (nums[0], nums[0]);
        for i in 1..nums.len() {
            min = min.min(nums[i]);
            max = max.max(nums[i]);
        }
        let diff = max - min;
        if diff <= 2 * k {
            0
        } else {
            diff - 2 * k
        }
    }
}