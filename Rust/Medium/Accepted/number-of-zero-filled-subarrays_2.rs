impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        let mut zero_count = 0;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                zero_count += 1;
                count += zero_count;
            } else {
                zero_count = 0;
            }
        }
        count
    }
}