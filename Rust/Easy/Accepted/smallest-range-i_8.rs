impl Solution {
    pub fn smallest_range_i(nums: Vec<i32>, k: i32) -> i32 {
        
        let max = nums.iter().max().unwrap();
        let min = nums.iter().min().unwrap();
        let diff = max - min;
        if diff <= 2 * k {
            return 0;
        }
        return diff - 2 * k;
    }
}