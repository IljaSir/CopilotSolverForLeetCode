impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        let mut count = 0;
        let mut max_len = 0;
        while r < nums.len() {
            if nums[r] == 0 {
                count += 1;
            }
            r += 1;
            while count > 1 {
                if nums[l] == 0 {
                    count -= 1;
                }
                l += 1;
            }
            max_len = max_len.max(r - l);
        }
        max_len as i32 - 1
    }
}