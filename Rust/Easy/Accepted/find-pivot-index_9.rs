impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        
        let mut s: i32 = 0;
        let mut sum: i32 = 0;
        for i in 0..nums.len() {
            s += nums[i];
        }
        for i in 0..nums.len() {
            if sum == s - sum - nums[i] {
                return i as i32;
            }
            sum += nums[i];
        }
        -1
    }
}