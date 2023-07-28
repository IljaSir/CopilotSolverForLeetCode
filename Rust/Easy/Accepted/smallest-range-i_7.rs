impl Solution {
    pub fn smallest_range_i(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut min = nums[0];
        let mut max = nums[0];
        for i in 1..nums.len() {
            if min > nums[i] {
                min = nums[i];
            }
            if max < nums[i] {
                max = nums[i];
            }
        }
        if min + k >= max - k {
            0
        } else {
            max - min - 2 * k
        }
    }
}