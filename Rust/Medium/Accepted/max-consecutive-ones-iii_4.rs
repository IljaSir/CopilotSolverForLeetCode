impl Solution {
    pub fn longest_ones(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut left, mut right) = (0, 0);
        let (mut zeros, mut res) = (0, 0);
        while right < nums.len() {
            if nums[right] == 0 {
                zeros += 1;
            }
            while zeros > k {
                if nums[left] == 0 {
                    zeros -= 1;
                }
                left += 1;
            }
            res = res.max(right - left + 1);
            right += 1;
        }
        res as i32
    }
}