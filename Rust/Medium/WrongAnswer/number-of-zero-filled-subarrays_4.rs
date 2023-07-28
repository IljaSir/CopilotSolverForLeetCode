impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let mut zero_count = 0;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                zero_count += 1;
            } else {
                res += zero_count * (zero_count + 1) / 2;
                zero_count = 0;
            }
        }
        if zero_count > 0 {
            res += zero_count * (zero_count + 1) / 2;
        }
        return res as i64;
    }
}