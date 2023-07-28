impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let mut zeros = 0;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                zeros += 1;
            } else {
                res += zeros * (zeros + 1) / 2;
                zeros = 0;
            }
        }
        res += zeros * (zeros + 1) / 2;
        res
    }
}