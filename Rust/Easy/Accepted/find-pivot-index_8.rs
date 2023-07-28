impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        
        let mut left: i32 = 0;
        let mut right: i32 = nums.iter().sum();
        for (i, v) in nums.iter().enumerate() {
            if left == right - v {
                return i as i32;
            }
            left += v;
            right -= v;
        }
        -1
    }
}