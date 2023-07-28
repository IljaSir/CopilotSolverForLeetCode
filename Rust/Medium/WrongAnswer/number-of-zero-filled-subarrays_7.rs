impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        let mut zero_count = 0;
        while j < nums.len() {
            if nums[j] == 0 {
                zero_count += 1;
            }
            j += 1;
            while zero_count > 1 {
                if nums[i] == 0 {
                    zero_count -= 1;
                }
                i += 1;
            }
            count += (j - i) as i64;
        }
        count
    }
}