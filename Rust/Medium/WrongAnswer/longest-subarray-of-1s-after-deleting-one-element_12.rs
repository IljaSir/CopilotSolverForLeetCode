impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_zero = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                count += 1;
            } else {
                max_zero = max_zero.max(count);
                count = 0;
            }
        }
        max_zero.max(count)
    }
}