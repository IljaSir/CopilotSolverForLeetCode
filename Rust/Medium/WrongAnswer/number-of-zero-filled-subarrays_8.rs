impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        let mut zero_count = 0;
        let mut zero_start = 0;
        let mut zero_end = 0;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                zero_count += 1;
                zero_end = i;
                if zero_count == 1 {
                    zero_start = i;
                }
            }
            if nums[i] != 0 || i == nums.len() - 1 {
                if zero_count > 0 {
                    count += ((zero_start + 1) * (nums.len() - zero_end)) as i64;
                    zero_count = 0;
                }
            }
        }
        count
    }
}