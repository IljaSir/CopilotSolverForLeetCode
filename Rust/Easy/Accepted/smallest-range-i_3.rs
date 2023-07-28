impl Solution {
    pub fn smallest_range_i(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut min, mut max) = (nums[0], nums[0]);
        for i in 0..nums.len() {
            min = min.min(nums[i]);
            max = max.max(nums[i]);
        }
        (max - min - 2 * k).max(0)
    }
}