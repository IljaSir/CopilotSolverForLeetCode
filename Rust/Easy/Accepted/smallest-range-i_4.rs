impl Solution {
    pub fn smallest_range_i(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut min, mut max) = (nums[0], nums[0]);
        for &n in &nums {
            min = min.min(n);
            max = max.max(n);
        }
        (max - min - 2 * k).max(0)
    }
}