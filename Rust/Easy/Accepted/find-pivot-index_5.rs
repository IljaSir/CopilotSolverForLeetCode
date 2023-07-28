impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        
        let sum: i32 = nums.iter().sum();
        let mut left_sum: i32 = 0;
        for (i, n) in nums.iter().enumerate() {
            if left_sum == sum - left_sum - n {
                return i as i32;
            }
            left_sum += n;
        }
        -1
    }
}