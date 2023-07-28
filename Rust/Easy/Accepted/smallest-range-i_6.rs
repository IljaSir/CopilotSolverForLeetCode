impl Solution {
    pub fn smallest_range_i(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut min, mut max) = (i32::MAX, i32::MIN);
        for n in nums {
            if n < min {
                min = n;
            }
            if n > max {
                max = n;
            }
        }
        if max - min > 2 * k {
            max - min - 2 * k
        } else {
            0
        }
    }
}