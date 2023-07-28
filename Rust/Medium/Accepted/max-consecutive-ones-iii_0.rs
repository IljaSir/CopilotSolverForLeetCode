impl Solution {
    pub fn longest_ones(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        let mut zeros = 0;
        let mut max_len = 0;
        while right < nums.len() {
            if nums[right] == 0 {
                zeros += 1;
            }
            right += 1;
            while zeros > k {
                if nums[left] == 0 {
                    zeros -= 1;
                }
                left += 1;
            }
            max_len = max_len.max(right - left);
        }
        max_len as i32
    }
}