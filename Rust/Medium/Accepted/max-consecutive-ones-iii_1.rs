impl Solution {
    pub fn longest_ones(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        let mut k = k;
        let mut ans = 0;
        while right < nums.len() {
            if nums[right] == 0 {
                k -= 1;
            }
            while k < 0 {
                if nums[left] == 0 {
                    k += 1;
                }
                left += 1;
            }
            right += 1;
            ans = ans.max(right - left);
        }
        ans as i32
    }
}