impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                count += 1;
            } else {
                res += count * (count + 1) / 2;
                count = 0;
            }
        }
        res += count * (count + 1) / 2;
        res as i64
    }
}