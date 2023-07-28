impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        
        let mut count: i64 = 0;
        let mut zero_count: i64 = 0;
        for i in nums {
            if i == 0 {
                zero_count += 1;
            } else {
                count += zero_count * (zero_count + 1) / 2;
                zero_count = 0;
            }
        }
        count += zero_count * (zero_count + 1) / 2;
        count
    }
}