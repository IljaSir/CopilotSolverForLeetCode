impl Solution {
    pub fn longest_ones(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        let mut zero_count = 0;
        let mut max_len = 0;
        while r < nums.len() {
            if nums[r] == 0 {
                zero_count += 1;
            }
            while zero_count > k {
                if nums[l] == 0 {
                    zero_count -= 1;
                }
                l += 1;
            }
            max_len = max_len.max(r - l + 1);
            r += 1;
        }
        max_len as i32
    }
}