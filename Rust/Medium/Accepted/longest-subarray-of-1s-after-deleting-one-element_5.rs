impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let (mut l, mut r, mut k) = (0, 0, 0);
        let mut ans = 0;
        while r < nums.len() {
            if nums[r] == 0 {
                k += 1;
            }
            while k > 1 {
                if nums[l] == 0 {
                    k -= 1;
                }
                l += 1;
            }
            ans = ans.max(r - l);
            r += 1;
        }
        ans as i32
    }
}