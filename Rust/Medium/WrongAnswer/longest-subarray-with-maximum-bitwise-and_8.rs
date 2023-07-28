impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_len = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] > max {
                max = nums[i];
                max_len = 1;
            } else if nums[i] == max {
                max_len += 1;
            }
            if max_len == 1 {
                count += 1;
            } else {
                count = max_len;
            }
        }
        count
    }
}